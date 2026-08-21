class Solution {
    public int lengthOfLongestSubstring(String s) {
        char [] arr=s.toCharArray();
        List<Character>list=new ArrayList<>();
        int left =0;
        int right =0;
        int maxLen=0;
        int n =s.length();
        while(right<n){
            if(!list.contains(arr[right])){
                list.add(arr[right]);
                maxLen =Math.max(maxLen,list.size());
                right++;
            }else{
                list.remove(Character.valueOf(arr[left]));
                left++;
            }
        }
        return maxLen;
    }
}