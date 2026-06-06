class Solution {
    Integer[]dp;
    public int jump(int[] nums) {
        int n = nums.length ;
        dp=new Integer[n+1];
        return solve(nums,0,n);
    }
    private int solve(int []nums,int idx ,int n ){
        int ans = Integer.MAX_VALUE;
        if(idx>=n-1 )return 0;
        if(dp[idx]!=null)return dp[idx];
        for(int i = 1;i<=nums[idx];i++){
             int take = solve(nums,idx+i,n);
             if(take!=Integer.MAX_VALUE){
                ans = Math.min(ans,1+take);
             }
             
        }
        dp[idx]=ans ;
        return dp[idx] ;
    }
}