class Solution {
    //Integer[][]dp;
    public int lengthOfLIS(int[] nums) {
        // dp=new Integer[nums.length+1][nums.length+1];
        // return solve(nums,0,-1);
        //tabulation
        // int n = nums.length ;
        // int []dp = new int [n+1];
        // int maxLis=0;
        // Arrays.fill(dp,1);
        // for(int i =0;i<n;i++){
        //     for(int j =0;j<i;j++){
        //         if(nums[j]<nums[i]){
        //             dp[i]=Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        //     maxLis=Math.max(maxLis,dp[i]);
        // }
        // return maxLis;

        // o(nlogn)approach binary search wali 
        List<Integer>ans = new ArrayList<>();
        for(int num:nums){
            int left =0;
            int right =ans.size();
            while(left<right){
                int mid =left+(right-left)/2;
                if(ans.get(mid)<num){
                    left =mid +1;

                }else{
                    right =mid;
                }
            }
            if(left == ans.size()){
                ans.add(num);
            }else{
                ans.set(left,num);
            }
        }
        return ans.size();

        
    }
    // private int solve(int []nums,int i,int p){
        
    //     if(i==nums.length)return 0;
    //     if(dp[i][p+1]!=null)return dp[i][p+1];
    //     int take=0;
    //     if(p==-1||nums[i]>nums[p]){
    //         take=1+solve(nums,i+1,i);

    //     }
    //     int skip=solve(nums,i+1,p);
    //     return dp[i][p+1]=Math.max(take,skip);
    // }
}