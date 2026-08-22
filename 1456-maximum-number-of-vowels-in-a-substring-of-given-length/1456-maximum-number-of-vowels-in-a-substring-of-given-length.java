class Solution {
    private boolean isVowel(char ch){
        if(ch=='a'|| ch=='e'|| ch=='i'||ch=='o'|| ch=='u')return true ;
        return false ;
    }
    public int maxVowels(String s, int k) {
        char[]arr=s.toCharArray();
        int n=s.length();
        int count =0;
        int maxCount =0;
        int left =0;
        int right=k-1;
        for(int i=0;i<k;i++){
            if(isVowel(arr[i])){
                count ++;
            }
        }
        maxCount =Math.max(count,maxCount);
        while(right<n-1){
            // remove left character
            if(isVowel(s.charAt(left))){
                count --;

            }
            // add right character
            if(isVowel(s.charAt(right+1))){
                count ++;
            }
            
            maxCount =Math.max(count ,maxCount);
            left++;
            right++;
        }
        return maxCount ;

    }
}