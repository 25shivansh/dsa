class Solution {
    public int characterReplacement(String s, int k) {
        int[]hash=new int[26];// hash array to calculate the frequency of each character 
        int maxFreq=0;
        int result =0;
        int left =0;
        int n =s.length();
        for(int right=0;right<n;right++){
            hash[s.charAt(right)-'A']++;// increase the frequency count 
            maxFreq=Math.max(maxFreq,hash[s.charAt(right)-'A']);
            while((right-left+1)-maxFreq>k){
                // remove the frequency untill it comes under k 
                hash[s.charAt(left)-'A']--;
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}