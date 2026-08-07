class Solution {
    public int minimumRounds(int[] tasks) {
        int round =0;
        int n =tasks.length ;
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int freq=entry.getValue();
            if(freq==1)return -1;
            while(freq>0){
                if(freq==2||freq==3){
                    round ++;
                    freq=0;
                }else if(freq%3==1){
                    freq-=2;
                    round ++;
                    
                }else{
                    freq-=3;
                    round ++;
                }
            }
            

            
        }
        return round ;
    }
}