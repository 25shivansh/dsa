class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        char [] ans = word.toCharArray();
        for(int i =0 ;i<ans .length ;i++ ){
            set.add(ans[i]);
        }
        for ( char ch : set){
            if(ch>='a' && set.contains(Character.toUpperCase(ch))){
                count ++;
            }
        }
        return count ;
    }
}