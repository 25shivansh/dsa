class Solution {
    public int numOfSubarrays(int[] arr) {
        // brute force 
        int n=arr.length;
        // int cnt =0;
        // for(int i=0;i<n;i++){
        //     int sum =0;
        //     for(int j=i;j<n;j++){
        //         sum+=arr[j];
        //         if(sum%2!=0){
        //             cnt ++;
        //         }
        //     }
        // }
        // return cnt ;
        int mod=1000000007;
        int even=1;
        int odd=0;
        int sum =0;
        long ans =0;
        for(int num:arr){
            sum+=num;
            if(sum%2==0){
                ans+=odd;
                even++;
            }else{
                ans+=even;
                odd++;
            }
        }
        return (int)(ans%mod);

    }
}