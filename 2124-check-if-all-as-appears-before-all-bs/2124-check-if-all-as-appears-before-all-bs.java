class Solution {
    public boolean checkString(String s) {
        String str=new String(s);
        char []ch=str.toCharArray();
        Arrays.sort(ch);
        String newStr=new String(ch);
        return s.equals(newStr); 
    }
}