class Solution {
    Integer[]dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        dp=new Integer[n+1];
        int case1=solve(nums,0,n-2);
        dp=new Integer[n+1];
        int case2=solve(nums,1,n-1);
        return Math.max(case1,case2);
    }
    private int solve(int []nums, int i , int end ){
        if(i>end)return 0;
        if(dp[i]!=null)return dp[i];
        int rob = nums[i]+solve(nums,i+2,end);
        int skip = solve(nums,i+1,end);
        return dp[i]=Math.max(rob,skip);
    }
}