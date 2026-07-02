class Solution {
    class DSU{
        int []parent ;
        int []size ;
        DSU(int n){
            parent = new int[n];
            size =new int[n];
            for(int i =0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
            
        }
        int find(int x ){
            if(parent[x]==x){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        void union(int u,int v){
            int pu=find(u);
            int pv=find(v);
            if(pu==pv)return ;
            if(size[pu]<size[pv]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU(accounts.size());
        // step 1 account index matching 
        HashMap<String,Integer>map=new HashMap<>();
        for(int i =0;i<accounts.size();i++){
            List<String>acc=accounts.get(i);
            for(int j =1;j<acc.size();j++){
                String email=acc.get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }else{
                    dsu.union(i,map.get(email));
                }
            }
        }
        // step 2 --> root ke according email put karo 
        HashMap<Integer,List<String>>merged=new HashMap<>();
        for(String email : map.keySet()){
            int idx = map.get(email);
            int root = dsu.find(idx);
            merged.putIfAbsent(root,new ArrayList<>());
            merged.get(root).add(email);
        }
        // sort the list 
        for(List<String>list:merged.values()){
            Collections.sort(list);
        }
        List<List<String >> ans = new ArrayList<>();
        for(int root :merged.keySet()){
            List<String>curr = new ArrayList<>();
            curr.add(accounts.get(root).get(0));// name 
            curr.addAll(merged.get(root));
            ans.add(curr);
        }
        return ans ;
    }
}