class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length ;
        Arrays.sort(cost);
        for(int i =0;i<n/2;i++){
            int temp = cost[i];
            cost[i] = cost[cost.length - i - 1];
            cost[cost.length - i - 1] = temp;
        }
        int total = 0;
        for(int i =0;i<n;i++){
            if(i%3!=2){
                total +=cost[i];
            }
        }
        return total ;
    }
}