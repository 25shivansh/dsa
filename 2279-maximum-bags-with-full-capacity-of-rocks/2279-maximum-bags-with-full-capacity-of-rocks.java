class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int count =0;
        int n=capacity.length ;
        int [] need = new int [n];
        
        for(int i=0;i<n;i++){
            need[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(need);
        for(int i =0;i<need.length ;i++){
            if(need[i]==0){
                count ++;
            }else{
                if(need[i]>additionalRocks){
                    continue ;
                }else if((need[i]-additionalRocks)<=additionalRocks){
                    count ++;
                    additionalRocks-=need[i];
                }
            }
        }
        return count ;
    }
}