class Solution {
    // Integer[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp=new int[n+1][m+1];
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    
    // private int solve(String s1,String s2,int i,int j){
    //     if(i>=s1.length()||j>=s2.length()){
    //         return 0;//no more options remaining to iterate 
    //     }
    //     if(dp[i][j]!=null)return dp[i][j];
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return 1+solve(s1,s2,i+1,j+1);//character matched , so remove the char and add 1
    //     }
    //     return dp[i][j]= Math.max(solve(s1,s2,i,j+1),solve(s1,s2,i+1,j));//return the max value of every option in the recursion untill the base condition is met 
    }
}