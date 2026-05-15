class Solution {
    public int myAtoi(String s) {
        int idx =0;
        int n=s.length();
        int sign =1;
        int  total =0;
        // check the whitespace 
        while(idx<n&&s.charAt(idx)==' '){
            idx++;
        }
        if(idx == n)return 0;
        //check the sign 
        if(s.charAt(idx)=='-'|| s.charAt(idx)=='+'){
            sign =(s.charAt(idx)=='-')?-1:1;
            idx ++;

        }
        // add to number and also check whether it is digit or not 
       while(idx < n && Character.isDigit(s.charAt(idx))){
        int digit =s.charAt(idx)-'0';
        if(total>(Integer.MAX_VALUE-digit)/10){
            return sign ==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        total=total*10+digit;
        idx++;
       }
       return total*sign ;
    }
}