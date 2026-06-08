class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length ;
        int left = 0 ;
        int right = n-1;
        int i = 0;
        int j = n-1;
        int [] ans = new int [n];
        while(i<n){
            if(nums[i]<pivot){
                ans[left++]=nums[i];
                
            }
            if(nums[j]>pivot){
                ans[right--]=nums[j];
            }
            i++;
            j--;
        }
        
        while(left<=right){
            ans[left++]=pivot ;
        }
        return ans;
    }
}