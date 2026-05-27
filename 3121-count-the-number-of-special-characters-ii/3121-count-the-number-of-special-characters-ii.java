class Solution {
    public int numberOfSpecialChars(String word) {
        char [] ans = word.toCharArray();
        int n = ans.length ;
        int []lower = new int [26];
        int []upper = new int [26];
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);
        for(int i = 0 ;i<n;i++){
            if(ans[i]>='a'&&ans[i]<='z'){
                lower[ans[i]-'a']=i;// storing last index of lower case char  
            }else{
                // upper 
                if(upper[ans[i]-'A']==-1){
                    upper[ans[i]-'A']=i;// first index of upper case char 
                }
            }
        }
        int count = 0;
        for(int i = 0; i<26;i++){
            if(lower[i]!=-1&& upper[i]!=-1&& lower[i]<upper[i]){
                count ++ ;
            }
        }
        return count ;

    }
}