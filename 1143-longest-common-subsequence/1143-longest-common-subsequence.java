class Solution {
    // Integer[][]dp;
    // private int solve(String text1,String text2,int i,int j){
    //     int m=text1.length();
    //     int n=text2.length();
    //     // base case -->out of bound 
    //     if(i<0 ||i>=m||j<0||j>=n){
    //         return 0;
    //     }
    //     if(dp[i][j]!=null)return dp[i][j];
    //     // take aur skip ka hume logic lagana hain 
    //     if(text1.charAt(i)==text2.charAt(j)){
    //         return 1+solve(text1,text2,i+1,j+1);
    //     }
    //     return dp[i][j]= Math.max(solve(text1,text2,i+1,j),solve(text1,text2,i,j+1));
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        // method 1 -->rec+memo
        // dp=new Integer[text1.length()+1][text2.length()+1];
        // return solve(text1,text2,0,0);
        

        // <------------- TABULATION ----------------->
        int [][]dp;
        int n=text1.length();
        int m=text2.length();
        dp=new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                
            }
            
        }
        return dp[n][m];
    }
}