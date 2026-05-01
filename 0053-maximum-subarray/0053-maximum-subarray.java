class Solution {
    public int maxSubArray(int[] nums) {
        // int maxSum=Integer.MIN_VALUE;
         int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int currSum=0;
        //     for(int j=i;j<n;j++){
        //         currSum+=nums[j];
        //         maxSum=Math.max(currSum,maxSum);
        //     }
        // }
        // return maxSum;

        //KADANE ALGO
        int currSum=nums[0];
        int maxSum =nums[0];
        for(int i=1;i<n;i++){
            currSum=Math.max(nums[i],currSum+nums[i]);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum ;

        
    }
}