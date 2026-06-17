// rec + memo 
class Solution {
    Integer[]dp;
    public int climbStairs(int n) {
        dp=new Integer[n+1];
        return solve(n);
    }
    private int solve(int n){
        if(n==1)return 1;
        if(n==2)return 2;
        if(dp[n]!=null)return dp[n];
        return dp[n]=solve(n-1)+solve(n-2);
    }
}