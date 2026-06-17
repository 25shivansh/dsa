class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int m=nums1.length;
        // int n=nums2.length;
        // int total=m+n;
        // int i=0,j=0;
        // int count =0;
        // int prev=0,curr=0;
        // while(count <= total/2){
        //     prev=curr;
        //     if(i<m&& (j>=n || nums1[i]<=nums2[j])){
        //         curr=nums1[i++];
        //     }else{
        //         curr=nums2[j++];
        //     }
        //     count ++;
        // }
        // if(total%2==0){
        //     return (prev+curr)/2.0;
        // }else{
        //     return curr;
        // }
        int n =nums1.length ;
        int m =nums2.length ;
        int total =n+m;
        int count =0;
        int i=0,j=0;
        int prev=0,curr=0;
        while(count<=total/2){
            prev =curr;
            if(i<n&&(j>=m||nums1[i]<=nums2[j])){
                curr=nums1[i++];

            }else{
                curr=nums2[j++];
            }
            count ++;
        }
        if(total%2==0)return (prev+curr)/2.0;
        else return curr ;
    }
}