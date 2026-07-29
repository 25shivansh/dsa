class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // brute force approach 
        // HashSet<Integer>set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int unique_element = set.size();
        // int n = nums.length ;
        // int count =0;
        
        // for(int i =0;i<n;i++){
        //     HashSet<Integer>set2=new HashSet<>();
        //     for(int j = i;j<n;j++){
        //         set2.add(nums[j]);
        //         if(set2.size()==unique_element){
        //             count ++;
        //         }
        //     }
        // }
        // return count ;

        // optimal approach 
        int n = nums.length ;
        int left =0;
        int count =0;
        HashSet<Integer>set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int unique_element = set.size();
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int right =0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()==unique_element){
                count +=n-right;
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left])==0) {
                    map.remove(nums[left]);
                }

                left++;
            }
        }
        return count ;

        

    }
}