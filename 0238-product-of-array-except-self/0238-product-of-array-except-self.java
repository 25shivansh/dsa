class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int []ans=new int [n];
        // for(int i=0;i<n;i++){
        //     int product =1;
        //     for(int j=0;j<n;j++){
        //         if(i!=j){
        //             product*=nums[j];
        //         }
        //     }
        //     ans[i]=product;
        // }
        // return ans ;
        
        // OPTIMAL APPROACH
        // BUILD LEFT(PREFIX) PRODUCT  
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        // right product(suffix)
        int right =1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*right ;
            right*=nums[i];
        }
        return ans ;


    }
}