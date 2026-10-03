class Solution {
    public int longestValidParentheses(String s) {
        // we will use stack
        int maxLen=0;
        Stack<Integer>st=new Stack<>();
        // store default index==-1
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                maxLen=Math.max(maxLen,i-st.peek());
            }
        }
        return maxLen;
    }
}