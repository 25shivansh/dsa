class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String>set = new HashSet<>();
        for(int i =0;i<arr1.length ;i++){
            String s = Integer.toString(arr1[i]);
            for(int j = 1 ; j <=s.length() ; j++){
                set.add(s.substring(0,j));
            }
            
        }
        
        int max = 0;
        for(int i =0 ;i<arr2.length ;i++){
            String str =Integer.toString(arr2[i]);
            for(int j = 1 ;j<=str.length() ;j++){
                if(set.contains(str.substring(0,j))){
                    max = Math.max(max,j);
                }
                
            }
        }
        
        return max ;

        
    }
}