class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length ;
        int [] ans = new int[2];
        int left = 0 ;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){ 
                int l = mid ;
                while(l>=0 && nums[l]==target){
                    l--;
                }
                int r = mid ;
                while(r<n && nums[r]==target){
                    r++;
                }
                ans[0]=l+1;
                ans[1]=r-1;
                return ans ;

            }else if(nums[mid]<target){
                left = mid +1;
            }else{
                right = mid -1;

            }
            
        }
        return new int[]{-1,-1};
    }
}