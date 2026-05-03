class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // BRUTE FORCE --GETTING ACCEPTED 
        int n=nums.length;
        int count =0;
        int product =1;
        int left =0;
        if(k<=1)return 0;
        // for(int i=0;i<n;i++){
        //     int product =1;
        //     for(int j=i;j<n;j++){
        //         product*=nums[j];
        //         if(product<k){
        //             count ++;
        //         }else{
        //             break ;
        //         }
        //     }
        // }
        // return count ;
        for(int right=0;right<n;right++){
            product*=nums[right];
            while(product>=k){
                product/=nums[left];
                left ++;
            }
            count +=right-left+1;
        }
        return count ;
        
    }
}