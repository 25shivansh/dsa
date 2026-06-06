class Solution {
    Boolean[]dp;
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length+1];
        return solve(nums,0,nums.length);
    }
    private boolean solve(int []nums,int idx,int n){
        if(idx == n-1)return true ;
        if(idx>=n)return true ;
        if(dp[idx]!=null)return dp[idx];
        for(int i =1;i<=nums[idx];i++){
            if(solve(nums,idx+i,n)==true){
                dp[idx]=true ;
                return dp[idx] ;
            }
        }
        return dp[idx]=false  ;
    }
}