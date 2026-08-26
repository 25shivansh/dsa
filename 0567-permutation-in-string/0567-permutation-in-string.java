class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n =s1.length();
        int m=s2.length();
        if(n>m)return  false ;
        char[]arr1=s1.toCharArray();
        Arrays.sort(arr1);
        String str=new String(arr1);
        for(int i=0;i<=m-n;i++){
            String substring=s2.substring(i,i+n);
            char[]arr2=substring.toCharArray();
            Arrays.sort(arr2);
            String subs=new String(arr2);
            if(str.equals(subs)){
                return true ;
            }
        }
        return false ;
    }
}