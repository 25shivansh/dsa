class Solution {
    public int findKthPositive(int[] arr, int k) {
       int num = 1;
       int idx = 0;
       int n =arr.length ;
       while(idx<n && k>0){
        if(arr[idx]==num){
            idx ++ ;
        }else {
            k -- ;
        }
        num ++ ;
       }
       while(k>0){
        num ++;
        k--;
       }
       return num -1;
    }
}