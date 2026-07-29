class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int unique_element = set.size();
        int n = nums.length ;
        int count =0;
        
        for(int i =0;i<n;i++){
            HashSet<Integer>set2=new HashSet<>();
            for(int j = i;j<n;j++){
                set2.add(nums[j]);
                if(set2.size()==unique_element){
                    count ++;
                }
            }
        }
        return count ;
    }
}