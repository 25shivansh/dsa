class Solution {
    int []dRow={-1,1,0,0};
    int []dCol={0,0,-1,1};
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][]visited =new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j]){
                    if(dfs(grid,-1,-1,n,m,i,j,visited,grid[i][j])){
                        return true ;
                    }
                }
            }
        }
        return false ;
    }
    private boolean dfs(char[][]grid,int pi,int pj,int n,int m,int i , int j,boolean [][]visited, char ch){
        visited[i][j]=true ;
        //visited marked 
        for(int d=0;d<4;d++){
            int nr=i+dRow[d];
            int nc=j+dCol[d];
            if(nr<0||nc<0||nr>=n||nc>=m)continue ;
            if(grid[nr][nc]!=ch)continue ;
            if(!visited[nr][nc]){
                if(dfs(grid,i,j,n,m,nr,nc,visited,ch))return true ;
            }else if(nr!=pi ||nc!=pj)return true ;

        }
        return  false ;
        



    }
}