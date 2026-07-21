class Solution {
    public int longestPalindrome(String[] words) {
        int n =words.length ;
        HashMap<String,Integer>map=new HashMap<>();
        for(String ch:words){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        boolean centerUsed = false ;// for frequency 1 wale strings 
        int result = 0;
        // start iterating on words one by one 
        for(String word:words){
            if (map.getOrDefault(word, 0) == 0){
                continue;
            }
            String rev = new StringBuilder(word).reverse().toString();
            if(!rev.equals(word)){// ab ba
                if(map.getOrDefault(word,0)>0 && map.getOrDefault(rev,0)>0){
                    map.put(word,map.get(word)-1);
                    map.put(rev,map.get(rev)-1);
                    result +=4;
                }

            }else{// pallindrome word for eg cc , aa 
                if(map.get(word)>=2){
                    map.put(word,map.get(word)-2);
                    result +=4;
                }else if(map.get(word)==1&&!centerUsed){
                    map.put(word,map.get(word)-1);
                    result +=2;
                    centerUsed=true ;
                }
            }
        }
        return result ;
    }
}