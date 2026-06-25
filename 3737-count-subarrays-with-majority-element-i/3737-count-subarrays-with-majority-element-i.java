class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n =nums.length;
        // brute force 
        // int res =0;
        // for(int i =0;i<n;i++){
        //     int count =0;
        //     for(int j =i;j<n;j++){
        //         if(nums[j]==target){
        //             count +=1;
        //         }
        //         if(count > (j-i+1)/2)res++;
                
        //     }
            
        // }
        // return res ;
        // simplified brute force 
        int res =0;
        for(int i =0;i<n;i++){
            int count =0;
            for(int j =i;j<n;j++){
                count +=(nums[j]==target)?+1:-1;
                if(count > 0)res++;
                
            }
            
            
        }
        return res ;
    }
}