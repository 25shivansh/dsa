// rec + memo 
// tabulation 
class Solution {
    // Integer[]dp;
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        if(n==1||n==2)return n;
        dp[1]=1;
        dp[2]=2;
        for(int i =3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // private int solve(int n){
    //     if(n==1)return 1;
    //     if(n==2)return 2;
    //     if(dp[n]!=null)return dp[n];
    //     return dp[n]=solve(n-1)+solve(n-2);
    // }
}