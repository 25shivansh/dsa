class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length ;
        int [][]seeds= new int [n][2];
        for(int i =0;i<n;i++){
            seeds[i][0]=plantTime[i];
            seeds[i][1]=growTime[i];
        }
        Arrays.sort(seeds,(a,b)->b[1]-a[1]);
        int prevPlantDays=0;
        int maxBloomDay=0;
        for(int i = 0;i<n;i++){
            int currPlantTime =seeds[i][0];
            int currGlowTime=seeds[i][1];
            prevPlantDays+=currPlantTime;
            int currentPlantBloomTime=prevPlantDays+currGlowTime;
            maxBloomDay=Math.max(maxBloomDay,currentPlantBloomTime);
        }
        return maxBloomDay;
    }
}