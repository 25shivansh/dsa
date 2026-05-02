class Solution {
    public int findMaxLength(int[] nums) {
        // int n=nums.length;
        // int maxLen =0;
        // for(int i=0;i<n;i++){
        //     int count0=0;
        //     int count1=0;
        //     for(int j=i;j<n;j++){
        //         if(nums[j]==0)count0++;
        //         else count1++;
        //         if(count0==count1){
        //             maxLen=Math.max(maxLen,j-i+1);
        //         }
        //     }
        // }
        // return maxLen;
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);//handle base case 
        int sum =0;
        int maxLen=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0)sum+=-1;
            else sum+=1;
            if(map.containsKey(sum)){
                int len =i-map.get(sum);
                maxLen=Math.max(len,maxLen);
            }else{
                map.put(sum,i);
            }

        }
        return maxLen ;
    }
}