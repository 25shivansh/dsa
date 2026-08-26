class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int left=0;
        int right=0;
        int stIndex=-1;
        int count=0;
        int[]hash=new int[128];
        int[]hash2=new int[128];
        int minLen=Integer.MAX_VALUE;
        for(char ch:t.toCharArray()){
            hash[ch]++;// count the frequency of each character 
        }
        while(right<n){
            //include the right element and increase its count 
            char ch = s.charAt(right);
            hash2[ch]++;
            // character is usefull 
            if(hash[ch]>0 && hash2[ch]<=hash[ch]){
                count++;
            }
            // window is valid 
            while(count==m){
                // update minimum window 
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    stIndex=left;
                }
                // remove left char 
                char leftChar = s.charAt(left);
                hash2[leftChar]--;
                if(hash[leftChar]>0&&hash2[leftChar]<hash[leftChar]){
                    count--;
                }
                left++; 
            }
            right++;
            

        }
        if(stIndex==-1){
            return "";
        }
        return s.substring(stIndex,stIndex+minLen);
    }
}