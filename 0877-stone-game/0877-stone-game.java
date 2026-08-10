class Solution {
    Integer[][]dp;
    public boolean stoneGame(int[] piles) {
        int sum =0;
        int n =piles.length ;
        dp=new Integer[n+1][n+1];
        for(int i=0;i<n;i++){
            sum+=piles[i];
        }
        int alice_score =solve(piles,0,n-1);
        int bobScore=sum-alice_score;
        return alice_score>sum/2;
    }
    private int solve(int []piles,int i,int j){
        
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int take_i=piles[i]+Math.min(solve(piles,i+2,j),solve(piles,i+1,j-1));
        int take_j=piles[j]+Math.min(solve(piles,i+1,j-1),solve(piles,i,j-2));
        return dp[i][j]=Math.max(take_i,take_j);

    }
}