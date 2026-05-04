class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // int n=nums.length;
        // int maxLen=0;
        // for(int i=0;i<n;i++){
        //     HashMap<Integer,Integer>map=new HashMap<>();
        //     for(int j=i;j<n;j++){
        //         map.put(nums[j],map.getOrDefault(nums[j],0)+1);
        //         if(map.get(nums[j])>k){
        //             break;
        //         }
        //         int len =j-i+1;
        //         maxLen=Math.max(len,maxLen);
        //     }
            
        // }
        // return maxLen;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            // include current element
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // if invalid → shrink window
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            // valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}