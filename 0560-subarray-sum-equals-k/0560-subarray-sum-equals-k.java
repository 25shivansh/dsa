class Solution {
    public int subarraySum(int[] nums, int k) {
    //    int count =0;
    //    int n=nums.length;
    //    for(int i=0;i<n;i++){
    //     int sum =0;
    //     for(int j=i;j<n;j++){
    //         sum+=nums[j];
    //         if(sum==k){
    //             count ++;
    //         }
    //     }
    //    }
    //    return count ; 
    // 
    // Map<Integer,Integer>map=new HashMap<>();
    // int count =0;
    // int sum =0;
    // map.put(0, 1);
    // for(int num :nums){
    //     sum+=num;
    //     int rem=sum-k;
    //     if(map.containsKey(rem)){
    //         count +=map.get(rem);
    //     }
    //     map.put(sum,map.getOrDefault(sum,0)+1);
    // }
    // return count ;

    Map<Integer,Integer>map=new HashMap<>();
    int count =0;
    int sum=0;
    map.put(0,1);
    for(int num:nums){
        sum+=num;
        int rem=sum-k;
        if(map.containsKey(rem)){
            count+=map.get(rem);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return count ;
    }
}