class Solution {
    Integer[][]dp;
    public int coinChange(int[] coins, int amount) {
        int n =coins.length ;
        dp=new Integer[n+1][amount+1];
        int ans = solve(coins,amount,0);
        return ans >=Integer.MAX_VALUE?-1:ans;
    }
    private int solve(int []coins,int amount ,int i){
        if(amount==0)return 0;
        if(i==coins.length || amount<0)return Integer.MAX_VALUE;
        if(dp[i][amount]!=null)return dp[i][amount];
        int take =Integer.MAX_VALUE;
        int res = solve(coins,amount-coins[i],i);
        if(res!=Integer.MAX_VALUE){
            take = 1+res;
        } 
        int skip = solve(coins,amount,i+1);
        return dp[i][amount]=Math.min(take,skip);
    }
}