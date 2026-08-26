class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n =s1.length();
        int m=s2.length();
        int []hash1=new int[26];
        int []hash2=new int[26];
        for(char ch:s1.toCharArray()){
            hash1[ch-'a']++;
        }
        int left =0;
        int right=0;
        while(right<m){
            hash2[s2.charAt(right)-'a']++;
            if(right-left+1>n){
                // time to shrink the window 
                hash2[s2.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(hash1,hash2)){
                return true ;
            }
            right++;
        }
        return false ;
    }
}