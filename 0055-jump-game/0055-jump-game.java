class Solution {
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean [] dp = new boolean[n+1];
        for(int i = 0 ;i< n;i++){
            dp[i]=false ;
        }
        dp[0]=true ;
        for(int i = 1 ;i< n;i++){
            for(int j=i-1 ; j>=0 ; j--){
                if(dp[j]==true && j+nums[j]>=i){
                    dp[i]=true ;
                    break ;
                }

            }

        }
        return dp[n-1];
        
        
    }
    // private boolean solve(int []nums,int idx,int n){
    //     if(idx == n-1)return true ;
    //     if(idx>=n)return true ;
    //     if(dp[idx]!=null)return dp[idx];
    //     for(int i =1;i<=nums[idx];i++){
    //         if(solve(nums,idx+i,n)==true){
    //             dp[idx]=true ;
    //             return dp[idx] ;
    //         }
    //     }
    //     return dp[idx]=false  ;
    // }
}