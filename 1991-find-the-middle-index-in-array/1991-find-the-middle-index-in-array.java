class Solution {
    public int findMiddleIndex(int[] nums) {
        int n=nums.length;
        int []prefix =new int [n];
        int []suffix=new int [n];
        prefix[0]=nums[0];
        //build prefix array
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        suffix[n-1]=nums[n-1];
        // build suffix array
        for(int i=n-2;i>=0;i--){
            suffix[i]=nums[i]+suffix[i+1];
        }
        for(int i=0;i<n;i++){
            int left =(i==0)?0:prefix[i-1];
            int right=(i==n-1)?0:suffix[i+1];
            if(left ==right){
                return i;
            }
            
        }
        return -1;
    }
}