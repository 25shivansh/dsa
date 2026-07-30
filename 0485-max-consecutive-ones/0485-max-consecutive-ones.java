class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length ;
        int currAns=0;
        int maxAns =0;
        for(int num : nums){
            if(num==1){
                currAns = currAns +1;
                maxAns = Math.max(currAns,maxAns);
            }else{
                currAns =0;
            } 
        }
        return maxAns ;
    }
}