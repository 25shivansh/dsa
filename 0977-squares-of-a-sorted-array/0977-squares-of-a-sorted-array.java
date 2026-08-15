class Solution {
    public int[] sortedSquares(int[] nums) {
        int n =nums.length ;
        int []ans =new int [n];
        int left =0;
        int right =n-1;
        int pos=n-1;
        while(left<=right){
            int ls=nums[left]*nums[left];
            int rs=nums[right]*nums[right];
            if(ls>rs){
                ans[pos]=ls;
                left ++;

            }else{
                ans[pos]=rs;
                right --;
            }
            pos--;
        }
        return ans ;
    }
}