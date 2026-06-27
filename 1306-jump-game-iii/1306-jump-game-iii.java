class Solution {
    Boolean []dp;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        dp=new Boolean[n+1];
        return solve(arr,start,new boolean[n+1]);

        
    }
    private boolean solve(int []arr,int i,boolean []visited){
        if(i<0 || i>=arr.length)return false  ;
        if(arr[i]==0)return true ;
        if(visited[i]){
            return false ;
        }
        if(dp[i]!=null)return dp[i];
        visited[i]=true ;
        boolean forward = solve(arr, i+arr[i],visited);
        boolean backward=solve(arr,i-arr[i],visited);
        visited[i]=false ;
        return dp[i]=forward || backward ;

    }
}