class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n =nums.length ;
        int [] ans = new int [n];
        int i=0;//positives
        int j =1;// negatives 
        for(int num:nums){
            if(num>0){
                ans[i]=num;
                i+=2;
            }else{
                ans[j]=num;
                j+=2;
            }
        }
        return ans ;
    }
}