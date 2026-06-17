class Solution {
    Integer []dp;
    public int rob(int[] nums) {
        dp=new Integer[nums.length+1];
        
        return solve(nums,0);
        
    }
    private int solve(int []nums,int i){
        if(i>=nums.length)return 0;
        if(dp[i]!=null)return dp[i];
        int rob=nums[i]+solve(nums,i+2);
        int skip=solve(nums,i+1);
        return dp[i]=Math.max(rob,skip);
    }
}