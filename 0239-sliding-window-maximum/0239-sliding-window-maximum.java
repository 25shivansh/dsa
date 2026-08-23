class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int []ans=new int[n-k+1];
        int index=0;
        Deque<Integer>dq=new ArrayDeque<>();
        for(int right=0;right<n;right++){
            // remove indices that are outside the window
            while(!dq.isEmpty()&&dq.peekFirst()<right-k+1){
                dq.pollFirst();
            }
            // remove smaller elements 
            while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[right]){
                dq.pollLast();
            }
            // add current index
            dq.offerLast(right);
            // window is ready
            if(right>=k-1){
                ans[index]=nums[dq.peekFirst()];
                index++;
            }
        }
        return ans ;

    }
}