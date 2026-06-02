class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        for(int i= 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                int landtime = landStartTime[i] + landDuration[i];
                int finish = Math.max(landtime , waterStartTime[j])+ waterDuration[j];

                int watertime = waterStartTime[j]+ waterDuration[j];
                int finish2 = Math.max(watertime , landStartTime[i]) + landDuration[i];

                ans = Math.min(ans , finish);
                ans = Math.min(ans , finish2);

            }
        }
        return ans;
    }
}