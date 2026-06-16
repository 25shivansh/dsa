class Solution {
    public String longestPalindrome(String s) {
        int n =s.length();
        boolean[][]dp=new boolean[n][n];
        int maxLen =0;
        int idx =0;
        // substring of length 1 is always pallindrom , for eg dp[0][0] or dp[1][1]
        for(int i = 0;i<n;i++){
            dp[i][i]=true ;
            maxLen =1;
        }
        // start from len = 2
        for(int len =2;len<=n;len++){
            for(int i =0;i<=n-len;i++){
                int j =i+len-1;
                if(s.charAt(i)==s.charAt(j)&&len==2){
                    dp[i][j]=true;
                    maxLen = 2;
                    idx=i;
                }else if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]==true){
                    dp[i][j]=true ;
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        idx=i;
                    }
                }else {
                    dp[i][j]=false ;
                }
            }
        }
        return s.substring(idx,idx+maxLen);
    }

}