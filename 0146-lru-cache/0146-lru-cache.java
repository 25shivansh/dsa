class LRUCache {
    List<Pair>cache =new ArrayList<>();
    int n;
    class Pair{
        int key;
        int value;
        Pair(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity) {
        n=capacity;
    }
    
    public int get(int key) {
        for(Pair p:cache){
            if(p.key==key){// we go the key ---
                int val=p.value;
                cache.remove(p);
                cache.add(p);// recently used 
                return val ;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(Pair p:cache){
            if(p.key==key){
                p.value=value;
                cache.remove(p);
                cache.add(p);// recently used 
                return ;
            }
        }
        // key doesnot exist and cache has enough space 
        if(cache.size()<n){
            cache.add(new Pair(key,value));
            return ;
        }
        // key does not exist and cache is full 
        cache.remove(0); // delete the lru as it is least recently used 
        cache.add(new Pair(key,value)); // then add the new key value pair 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */