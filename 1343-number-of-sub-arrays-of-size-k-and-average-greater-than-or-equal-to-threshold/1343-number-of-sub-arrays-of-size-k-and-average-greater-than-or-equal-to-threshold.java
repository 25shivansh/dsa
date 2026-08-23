class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n =arr.length;
        int sum=0;
        int count =0;
        int left =0;
        int right=k-1;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int avg=sum/k;
        if(avg>=threshold){
            count++;
        }
        while(right<n-1){
            sum-=arr[left];
            left++;
            right++;
            sum+=arr[right];
            avg=sum/k;
            if(avg>=threshold){
                count++;
            }
        }
        return count ;
    }
}