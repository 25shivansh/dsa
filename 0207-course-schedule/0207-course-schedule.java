class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int []pre :prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }
        boolean []visited =new boolean [numCourses];
        boolean []parent = new boolean [numCourses];
        for(int i = 0 ; i<numCourses;i++){
            if(!visited[i]){
                if(dfs(adj,visited,i,parent)){
                    return false;
                }
            }
        }
        return true ;

    }
    private boolean dfs(List<List<Integer>>adj , boolean []visited,int src,boolean []parent){
        visited[src]=true ;
        parent[src]=true ;
        for(int nei :adj.get(src)){
            if(!visited[nei]){
                if(dfs(adj,visited,nei,parent)){
                    return true ;
                }
                
            }else if(parent[nei]){
                return true ;
            }

        }
        parent[src]=false; // backtrack
        return false;

    }
}