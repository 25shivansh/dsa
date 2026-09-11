class Solution {
    Integer[][]dp;
    private int solve(int [][]grid,int i,int j){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0||i>=n||j<0||j>=m){
            return 0;
        }
        if(grid[i][j]==1)return 0;
        if(i==n-1 && j==m-1)return 1;
        if(dp[i][j]!=null)return dp[i][j];
        int down=solve(grid,i+1,j);
        int right=solve(grid,i,j+1);
        return dp[i][j]=down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new Integer[obstacleGrid.length+1][obstacleGrid[0].length+1];
        return solve(obstacleGrid,0,0);
    }
}