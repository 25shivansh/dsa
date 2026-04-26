class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int i=2;
        for(int j=2;j<n;j++){
            if(nums[j]!=nums[i-2]){
                
                nums[i]=nums[j];
                i++;
            }
        }
        return i;

    }
}