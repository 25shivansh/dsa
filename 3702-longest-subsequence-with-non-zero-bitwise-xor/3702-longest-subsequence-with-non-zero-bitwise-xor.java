class Solution {
    public int longestSubsequence(int[] nums) {
        int xor =0;
        boolean subs=true ;
        for(int num:nums){
            xor^=num;
            if(num!=0){
                subs=false ;
            }

        }
        if(subs){
            return 0;
        }
        if(xor!=0){
            return nums.length ;
        }
        return nums.length-1;
    }
}