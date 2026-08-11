class Solution {
    int[][]dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[m+1][n+1];
        for(String s:strs){
            int zeroes =0,ones=0;
            for(char ch : s.toCharArray()){
                if(ch=='0'){
                    zeroes++;
                }else{
                    ones++;
                }
            }
            for(int i=m;i>=zeroes;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroes][j-ones]+1);
                }
            }
        }
        
        return dp[m][n];
    }
}