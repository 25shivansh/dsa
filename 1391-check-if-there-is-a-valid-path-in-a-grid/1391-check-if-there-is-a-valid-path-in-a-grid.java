class Solution {
    int[][][] dirs = {
        {},
        {{0,-1},{0,1}},      // 1
        {{-1,0},{1,0}},      // 2
        {{0,-1},{1,0}},      // 3
        {{0,1},{1,0}},       // 4
        {{0,-1},{-1,0}},     // 5
        {{0,1},{-1,0}}       // 6
    };
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;
        boolean [][]visited=new boolean [n][m];
        
        return dfs(grid,n,m,0,0,visited) ;
        
    }
    private boolean dfs(int [][]grid ,int n,int m,int i,int j,boolean [][]visited){
        if (i == n - 1 && j == m - 1) {
            return true;
        }
        if(i<0||j<0||i>=n||j>=m){
            return false ;
        }
        //marking visited 
        visited[i][j]=true ;
        // traversing according to the question 
        for(int []d:dirs[grid[i][j]]){
            int nr=i+d[0];
            int nc =j+d[1];
            if(nr<0||nc<0||nr>=n||nc>=m||visited[nr][nc]){
                continue ;
            }
            // reverse logic
            for(int []back:dirs[grid[nr][nc]]){
                if(nr+back[0]==i && nc+back[1]==j){
                    if(dfs(grid,n,m,nr,nc,visited))return true ;
                }
            }
            //return false ;


        }
        return false ;


    }
}