class Solution {
    Boolean [][][]dp;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        dp=new Boolean[n][m][health+1];
        boolean [][]visited = new boolean[n][m];
        return dfs(grid,health, 0, 0 , n,m,visited);
    }
    private boolean dfs(List<List<Integer>>grid,int health , int i , int j , int n ,int m,boolean[][]visited){
        
        if(i<0||j<0||i>=n||j>=m){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(grid.get(i).get(j)==1){
            health --;
        }
        if(health<=0){
            return false ;
        }
        if(i==n-1 && j==m-1&& health>=1){
            return true ;
        }
        if(dp[i][j][health]!=null)return dp[i][j][health];
        visited[i][j]=true ;
        boolean ans =dfs(grid,health,i+1,j,n,m,visited)||
        dfs(grid,health,i,j+1,n,m,visited)||
        dfs(grid,health,i-1,j,n,m,visited)||
        dfs(grid,health,i,j-1,n,m,visited);
        visited[i][j]=false ;
        return dp[i][j][health]=ans ;
    }
}