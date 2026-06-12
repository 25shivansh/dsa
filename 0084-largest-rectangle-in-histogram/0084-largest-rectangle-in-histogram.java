class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length ;
        int maxArea = 0 ; 
        int []nsr = new int [n];
        int []nsl = new int[n];
       
        
        Stack<Integer>st = new Stack<>();
        // smaller element in right 
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty()&& heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=heights.length ;
            }else {
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        // smaller elememt in left 
        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        for(int i = 0;i<n;i++){
            int height = heights[i];
            int widht = nsr[i]-nsl[i]-1;
            int currArea= height*widht ;
            maxArea= Math.max(currArea,maxArea);  
        }
        return maxArea ;
    }
}