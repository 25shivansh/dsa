class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sorting the intervals on the basic of its starting time 
        Arrays.sort(intervals,(a,b)->{
            if (a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int count =1;
        int prevEnd=intervals[0][1];
        for(int i =1;i<intervals.length;i++){
            int currStart=intervals[i][0];
            int currEnd =intervals[i][1];
            if(currEnd<=prevEnd){
                continue ;// covered 
            }
            count ++;
            prevEnd =currEnd;
        }
        return count ;
    }
}