class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result ;
    }
    private static void backtrack(int index , int []nums,List<Integer>current,List<List<Integer>>result){
        // base case --> aakhri mein pahuchne pe result me add krdo 
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }
        // include
        current.add(nums[index]);
        // inlcdue ke baad aage badho
        backtrack(index+1,nums,current,result);
        // exclude --> core idea of backtracking
        current.remove(current.size()-1);
        // exclude ke baad aage bdho
        backtrack(index+1,nums,current,result);
    }
}