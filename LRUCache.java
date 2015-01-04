public class LRUCache {
    class Pair {
        Pair before;
        Pair after;
        int key;
        int value;
        
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        void addBefore(Pair exist) {
            before = exist.before;
            before.after = this;
            
            after = exist;
            exist.before = this;
        }
        
        void remove() {
            before.after = after;
            after.before = before;
        }
    }
    
    int size = 0;
    Pair header = null;
    HashMap<Integer, Pair> map = null;
    
    public LRUCache(int capacity) {
        this.header = new Pair(-1, -1);
        header.before = header;
        header.after = header;
        this.map = new HashMap<Integer, Pair>();
        this.size = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Pair pair = map.get(key);
            
            adjust(key, pair.value);
            
            return pair.value;
            
        }
        
        return -1;
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key)) {
            
            
            
            Pair newPair = new Pair(key,value);
            newPair.addBefore(header);
            map.put(key, newPair);
            
            if(map.size() == size+1) {
                Pair oldPair = map.get(header.after.key);
                
                oldPair.remove();
                map.remove(oldPair.key);
            }
        
        } else {
            adjust(key, value);
        }
    }
    
    public void adjust(int key, int value){
            Pair valuePair = map.get(key);
            valuePair.value = value;
            
            valuePair.remove();
            valuePair.addBefore(header);
            
    }
}