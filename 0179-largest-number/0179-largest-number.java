class Solution {
    public String largestNumber(int[] nums) {
        String [] ans = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            ans[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(ans,(a,b)->(b+a).compareTo(a+b));
        if(ans[0].equals("0")){
            return "0";
        }
        for(int i = 0 ; i<ans.length;i++){
            sb.append(ans[i]);
        }
        return sb.toString();

    }
}