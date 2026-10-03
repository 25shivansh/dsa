class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalIncome =0;
        int totalSpent=0;
        int total=0;
        int res=0;
        for(int i=0;i<n;i++){
            totalIncome+=gas[i];
            totalSpent+=cost[i];
        }
        if(totalIncome<totalSpent){
            return -1;
        }
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                res=i+1;
            }
        }
        return res ;
    }
}