class Solution {
    public int minChanges(String s) {
        //brute force approach 
        int n=s.length();
        char ch=s.charAt(0);
        int count =0;
        int changes=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==ch){
                count++;
                continue ;
            }
            // curr character s[i] is not equal to ch
            if(count%2==0){// previous substring is even length
                count=1;
            }else{
                //s[i] ko change krna pdega to make evene substring length
                changes+=1;
                count=0;
            }
            ch=s.charAt(i);// update to new character
        }
        return changes ;


    }
}