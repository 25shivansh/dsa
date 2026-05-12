class Solution {
    public int maxDepth(String s) {
        int curr =0;
        int res =0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                curr ++;
                res =Math.max(curr,res);
            }else if(ch==')'){
                curr --;
            }
        }
        return res ;
    }
}