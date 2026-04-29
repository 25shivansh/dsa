class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int curr=0;
        int maxGain=0;
        for(int num:gain){
            curr+=num;
            maxGain=Math.max(curr,maxGain);
        }
        return maxGain;

            
        
    }
}