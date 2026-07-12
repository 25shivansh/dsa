class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int  n = arr.length ;
        int [] newArr = Arrays.copyOf(arr,n);
        int [] ans = new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        
        Arrays.sort(newArr);
        int rank =1;
        for(int i = 0 ;i<n;i++){
            if(!map.containsKey(newArr[i])){
                map.put(newArr[i],rank++);

            }
            
        }
        for(int i = 0;i<n;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans ;

    }
}