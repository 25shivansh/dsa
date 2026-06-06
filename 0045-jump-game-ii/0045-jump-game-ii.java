class Solution {
    public int jump(int[] nums) {
        int minJump = 0;
        int maxReach = 0;
        int jump=0;
        int n = nums.length ;
        
        for(int i = 0;i<n-1;i++){
            maxReach = Math.max(maxReach,i+nums[i]);
            if(i==minJump){
                jump ++;
                minJump=maxReach;
            }
        }
        return jump ;
    }
}