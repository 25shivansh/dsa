class Solution {
    Integer[][]dp;
    public String longestPalindrome(String s) {
        int n = s.length();
        dp=new Integer[n+1][n+1];
        int maxLen =0;
        int start = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(solve(s,i,j)){
                    int len =j-i+1;
                    if(len>maxLen){
                        maxLen = Math.max(len,maxLen);
                        start =i;
                    }
                }
            }
        }
        return s.substring(start,maxLen+start);
    }
    private boolean solve(String s ,int i,int j){
        if(i>=j)return true ;
        if(dp[i][j]!=null)return dp[i][j]==1;
        if(s.charAt(i)==s.charAt(j)){
            boolean res = solve(s,i+1,j-1);
            dp[i][j]=res?1:0;
            return res ;
        }
        dp[i][j]=0;
        return false ;
    }
}