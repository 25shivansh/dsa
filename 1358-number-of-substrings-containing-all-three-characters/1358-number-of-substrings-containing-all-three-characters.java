class Solution {
    public int numberOfSubstrings(String s) {
        int count =0;
        int []lastSeen=new int [3];
        Arrays.fill(lastSeen,-1);
        int n =s.length();
        for(int i =0;i<n;i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1&&lastSeen[1]!=-1&&lastSeen[2]!=-1){
                count +=(1+Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]));
            }
        }
   
    
    // int n = s.length();
    // int count =0;
    // for(int i =0;i<n;i++){
    //     for(int j = i;j<n;j++){
    //         String sub = s.substring(i,j+1);
    //         if(sub.contains("a")&&sub.contains("b")&&sub.contains("c")){
    //             count +=1;
    //         }
    //     }
        
    // }
    return count ;
    }
}