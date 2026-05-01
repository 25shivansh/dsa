class Solution {
    public int pivotIndex(int[] nums) {
        // optimized approach of middle index of array question leetcode -->1991
        int n=nums.length;
        int sum =0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            
        }
        int cs =0;
        
        for(int i=0;i<n;i++){
            int ls=cs;
            int rs=sum-cs-nums[i];
            if(ls==rs){
                return i ;
            }
            cs+=nums[i];
        }
        return -1;
        

    }
}