class Solution {
    int components =0;
    int nodes =0;
    int degreesum=0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean []visited = new boolean [n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int u= edge[0];
            int v =edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                nodes=0;
                degreesum=0;
                dfs(adj,n,i,visited);
                if(degreesum/2==nodes*(nodes-1)/2){
                    components ++;
                }
                
            }
        }
        return components ;


    }
    private void dfs(List<List<Integer>>adj, int n ,int src, boolean []visited){
        visited[src]=true ;
        nodes++;
        degreesum +=adj.get(src).size();
        for(int nei :adj.get(src)){
            if(!visited[nei]){
                dfs(adj,n,nei,visited);
            }
        }
    }

}