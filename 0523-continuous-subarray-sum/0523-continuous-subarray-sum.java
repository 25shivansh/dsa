class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // brute force approach 
         int n = nums.length ;
        
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j =i+1;i<n;i++){
        //         sum+=nums[j];
        //         if(sum%k==0){
        //             return true ;
        //         }
        //     }
        // }
        // return false ;

        // OPTIMIZED APPROACH 
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem =sum%k;
            if(map.containsKey(rem)){
                int prevIndex = map.get(rem);
                if(i-prevIndex>=2){
                    return true ;
                }
            }else{
                map.put(rem,i);
            }
        }
        return false ;

    }
}