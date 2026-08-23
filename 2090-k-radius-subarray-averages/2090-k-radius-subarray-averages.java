class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n =nums.length ;
        int []ans =new int [n];
        Arrays.fill(ans,-1);
        long windowSum=0;
        int left =0;
        int right =2*k;
        int index=k;
        if(n<2*k + 1){
            return ans;
        }
        for(int i=0;i<=right;i++){
            windowSum+=nums[i];
        }
        int avg=(int)(windowSum/(2*k+1));
        ans[index]=avg;
        index++;
        while(right<n-1){
            windowSum-=nums[left];
            left++;
            right++;
            windowSum+=nums[right];
            avg=(int)(windowSum/(2*k+1));
            ans[index]=avg;
            index++;
        }
        return ans ;
    }
    
}