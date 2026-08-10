class Solution {
    Integer[]dp;
    public int integerBreak(int n) {
        dp=new Integer[n+1];
        return solve(n);
    }
    private int solve(int n){
        if(n==1)return 1;
        if(dp[n]!=null)return dp[n];
        int res =Integer.MIN_VALUE;
        for(int i=1;i<=n-1;i++){
            int product =i*Math.max(n-i,solve(n-i));
            res=Math.max(res,product);
        }
        return dp[n]=res ;

    }
}