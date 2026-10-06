class Solution {
    public int minAddToMakeValid(String s) {
        int n =s.length();
        Stack<Character>st=new Stack();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else if((s.charAt(i)==')' && st.isEmpty()) || (s.charAt(i)==')' && st.peek()==')')){
                st.push(s.charAt(i));
            }else {
                if(st.isEmpty()){
                    st.push(')');
                }else{
                    st.pop();
                }
                
            }
        }
        return st.size();
    }
}