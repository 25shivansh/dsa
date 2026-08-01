class Solution {
    Integer[][]dp;
    public boolean predictTheWinner(int[] nums) {
        dp=new Integer[nums.length+1][nums.length+1];
        return solve(nums,0,nums.length-1)>=0;

    }
    private int solve(int []nums,int i,int j){
        if(i==j){
            return nums[i];
        }
        if(dp[i][j]!=null)return dp[i][j];
        int pickRight=nums[i]-solve(nums,i+1,j);
        int pickLeft=nums[j]-solve(nums,i,j-1);
        return dp[i][j]=Math.max(pickRight,pickLeft);
    }
}