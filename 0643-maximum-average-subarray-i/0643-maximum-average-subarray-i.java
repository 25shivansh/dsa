class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n =nums.length ;
        int left =0;
        int right =k-1;
        
        
        double sum=0;
        
        for(int i=0;i<k;i++){
            sum+=nums[i];
            
        }
        double maxAvg=sum/k;
        while(right<n-1){
            sum-=nums[left];
            left++;
            right++;
            sum+=nums[right];
            double avg= sum/k;
            maxAvg=Math.max(avg,maxAvg);
            
        }
        return maxAvg;
    }
}