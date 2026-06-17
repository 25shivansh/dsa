// rec + memo 
class Solution {
    
    public String longestPalindrome(String s) {
        // int maxLen =0;
        // int start =0;
        int n =s.length();
        boolean[][] dp=new boolean[n+1][n+1];
        int maxLen =0;
        int idx =0;
        for(int i =0;i<n;i++){
            dp[i][i]=true ;
            maxLen =1;
        }
        for(int len=2;len<=n;len++){
            for(int i =0;i<=n-len;i++){
                int j =i+len-1;
                if(s.charAt(i)==s.charAt(j)&& len==2){
                    dp[i][j]=true ;
                    maxLen=2;
                    idx=i;
                }else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                    dp[i][j]=true ;
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        idx=i;
                    }
                }else {
                    dp[i][j]=false ;
                }
            }
        }
        return s.substring(idx,idx+maxLen);
        // for(int i =0;i<n;i++){
        //     for(int j =i;j<n;j++){
        //         int len =j-i+1;
        //         if(solve(s,i,j)){
        //             if(len>maxLen){
        //                 maxLen =Math.max(len,maxLen);
        //                 start=i;
        //             }
        //         }
        //     }
        // }
        // return s.substring(start,start+maxLen);
    }
    // private boolean solve(String s ,int i ,int j){
    //     if(i>=j)return true ;
    //     if(dp[i][j]!=null)return dp[i][j]==1;
    //     if(s.charAt(i)==s.charAt(j)){
    //         boolean res = solve(s,i+1,j-1);
    //         dp[i][j]=res?1:0;
    //         return res ;
    //     }
    //     dp[i][j]=0;
    //     return false ;
    // }
}