class Solution {
    public int majorityElement(int[] nums) {
        //boyre moore algo ---->
        int candidate =-1;
        int count =0;
        for(int num:nums){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count --;

            }
        }
        return candidate;
    }

}