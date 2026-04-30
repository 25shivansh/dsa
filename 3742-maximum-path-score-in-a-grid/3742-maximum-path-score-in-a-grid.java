class Solution {
    int [][][]dp;
    int n,m;
    public int maxPathScore(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        dp = new int[n][m][k + 1];

        // initialize with -2 (means uncomputed)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -2);
            }
        }
        int res=dfs(grid,n,m,k,0,0);
        return (res<0)?-1:res;
        
    }
    private int dfs(int [][]grid,int n,int m,int k,int i,int j){
        if(i>=n||j>=m)return -1;
        int cost =(grid[i][j] ==0)?0:1;
        int score =grid[i][j];
        if(k<cost)return -1;
        if(i==n-1&&j==m-1)return score ;
        if (dp[i][j][k] != -2) return dp[i][j][k];
        int newK=k-cost;
        int right=dfs(grid,n,m,newK,i,j+1);
        int down =dfs(grid,n,m,newK,i+1,j);
        int best=Math.max(right,down);
        if (best == -1) {
            dp[i][j][k] = -1;
        } else {
            dp[i][j][k] = score + best;
        }

        return dp[i][j][k];

    }
}