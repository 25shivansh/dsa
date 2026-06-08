class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length ;
        int i = 0 ;
        int j = n-1;
        int left = 0;
        int right = n-1;
        int [] ans = new int [n];
        while(i<n){
            if(nums[i]<pivot){
                ans[left]=nums[i];
                left ++;
            }
            if(nums[j]>pivot){
                ans[right]=nums[j];
                right--;
            }
            i++;
            j--;
        }
        while(left<=right){
            ans[left]=pivot;
            left ++;
        }
        return ans ;
    }
}