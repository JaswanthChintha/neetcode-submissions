class LFUCache {
    HashMap<Integer,Integer> cache;
    HashMap<Integer,Integer> frequency;
    HashMap<Integer,Integer> recent;
    int capacity;
    int time=0;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<>();
        frequency=new HashMap<>();
        recent=new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        frequency.put(key,frequency.get(key)+1);
        recent.put(key,++time);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(cache.containsKey(key)){
            cache.put(key,value);
            frequency.put(key,frequency.get(key)+1);
            recent.put(key,++time);
            return;
        }
        if(cache.size()==capacity){
            int minFreq=Integer.MAX_VALUE;
            int lrukey=-1;
            for(int key1:cache.keySet()){
                int freq=frequency.get(key1);
                if(freq<minFreq){
                    minFreq=freq;
                    lrukey=key1;
                }else if(freq==minFreq && recent.get(key1)<recent.get(lrukey)){
                    lrukey=key1;

                }
            }
            cache.remove(lrukey);
            frequency.remove(lrukey);
            recent.remove(lrukey);
        }
        cache.put(key,value);
        frequency.put(key,1);
        recent.put(key,++time);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */