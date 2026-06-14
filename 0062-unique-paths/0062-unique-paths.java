class Solution {
    Integer[][]dp;
    public int uniquePaths(int m, int n) {
        dp= new Integer[m+1][n+1];
        return memo(m,n,0,0);

    }
    private int memo(int m,int n ,int i,int j ){
        if(i<0||i>=m||j<0||j>=n)return 0;
        if(i==m-1 || j== n-1)return 1;
        if(dp[i][j]!=null)return dp[i][j];
        int down = memo(m,n,i+1,j);
        int right = memo(m,n,i,j+1);
        return dp[i][j]=down+right ;
    }
}