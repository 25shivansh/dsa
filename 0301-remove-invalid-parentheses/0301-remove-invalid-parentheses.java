class Solution {
    private Set<String>st=new HashSet<>();
    private int n;
    private int maxLen;
    private void solve(String s,int i, StringBuilder curr,int count){
        // base case ->1 => Early prunning 
        if(count<0){
            return ;
        }
        // base case ->2=> if all the characters are checked then 
        if(i==s.length()){
            if(count==0){// checking if the paranthesis is balanced or not 
                if(curr.length()>maxLen){
                    maxLen=curr.length();
                    st.clear();
                }
                if(curr.length()==maxLen){
                    st.add(curr.toString());
                }

            }
            return ;
        }
        char ch=s.charAt(i);
        if(ch!='(' && ch!=')'){
            curr.append(ch);
            solve(s,i+1,curr,count);
            curr.deleteCharAt(curr.length()-1);
            return ;
        }
        curr.append(ch);
        solve(s,i+1,curr,count+(ch=='('?1:-1));
        curr.deleteCharAt(curr.length()-1);
        solve(s,i+1,curr,count); 
    }
    public List<String> removeInvalidParentheses(String s) {
        n=s.length();
        maxLen=0;
        st.clear();
        solve(s,0,new StringBuilder(),0);
        return new ArrayList<>(st);
    }
}