// rec + memo 
// tabulation 
// space optimized code 
class Solution {
    // Integer[]dp;
    public int climbStairs(int n) {
        // int []dp=new int[n+1];
        // if(n==1||n==2)return n;
        // dp[1]=1;
        // dp[2]=2;
        // for(int i =3;i<=n;i++){
        //     dp[i]=dp[i-1]+dp[i-2];
        // }
        // return dp[n];
        int prev=1;
        int prev2=1;
        for(int i =2;i<=n;i++){
            int curri=prev+prev2;
            prev2=prev;
            prev=curri;
        }
        return prev ;
    }
    // private int solve(int n){
    //     if(n==1)return 1;
    //     if(n==2)return 2;
    //     if(dp[n]!=null)return dp[n];
    //     return dp[n]=solve(n-1)+solve(n-2);
    // }
}