class Solution {
    private Integer[]dp;
    private int solve(int n,int []costs,int idx){
        if(idx==n)return 0 ;// reached 
        if(dp[idx]!=null)return dp[idx];
        int ans =Integer.MAX_VALUE;
        for(int jump=1;jump<=3;jump++){
            int next=idx+jump;
            if(next<=n){
                int cost = costs[next-1]+jump*jump;
                ans=Math.min(ans,cost+solve(n,costs,next));
            }
        }
        return dp[idx]=ans;


    }
    public int climbStairs(int n, int[] costs) {
        dp=new Integer[n+1];
        return solve(n,costs,0);

    }
}