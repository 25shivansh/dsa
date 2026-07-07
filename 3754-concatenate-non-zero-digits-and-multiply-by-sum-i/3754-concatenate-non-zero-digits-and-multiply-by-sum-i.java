class Solution {
    public long sumAndMultiply(int n) {
        
        String s=String.valueOf(n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                sb.append(s.charAt(i));
            }
        }
        if(sb.length()==0)return 0;
        long x=Integer.parseInt(sb.toString());
        long temp=x;
        long sum=0;
        while(temp>0){
            sum+=temp%10;
            temp/=10;
            
            
        }
        return x*sum;
    }
}