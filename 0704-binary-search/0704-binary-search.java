class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        // int low =0;
        // int high =n-1;
        // while(low<=high){
        //     int mid = low+(high-low)/2;
        //     if(nums[mid]==target){
        //         return mid ;
        //     }else if(nums[mid]<target){
        //         low =mid+1 ;
        //     }else{
        //         high =mid -1;
        //     }
        // }
        // return -1;
        
        return bsRecursive(nums,0,n-1,target);
    }
    private int bsRecursive(int []nums,int low ,int high ,int target){
        int mid =low+(high-low)/2;
        if(low>high)return -1;
        if(nums[mid]==target){
            return mid ;
        }else if(nums[mid]<target){
           return bsRecursive(nums,mid+1,high,target);
        }else{
           return  bsRecursive(nums,low,mid -1,target);
        }
        

    }
}