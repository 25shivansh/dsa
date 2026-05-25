class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length ;
        int num =1;
        int idx = 0;
        while(idx<n&& k>0){
            if(num == arr[idx]){
                idx ++;// move forward in the array 
            
            }else{
                k--; // missing number found 
            }
            num ++; // move to next number in the array 
        }
        while(k>0){
            num ++;
            k--;
        }
        return num -1;
    }
}