class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> m = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }
        int val = m.get(key);
        m.remove(key);
        m.put(key,val);
        return m.get(key);
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            m.remove(key);
            m.put(key,value);
            return;
        }
        if(m.size()==cap){
            m.remove(m.keySet().iterator().next());
        }
        m.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */