package problems.design.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    class CacheEntry {
        private int data;
        private int frequency;

        // default constructor
        private CacheEntry() {
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }
    }

    private static int initialCapacity = 10;
    private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<Integer, CacheEntry>();

    /*
     * LinkedHashMap is used because it has features of both HashMap and LinkedList.
     * Thus, we can get an entry in O(1) and also, we can iterate over it easily.
     */
    public LFUCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void put(int key, int data) {
        if (!isFull()) {
            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        } else {
            int entryKeyToBeRemoved = getLFUKey();
            cacheMap.remove(entryKeyToBeRemoved);

            CacheEntry temp = new CacheEntry();
            temp.setData(data);
            temp.setFrequency(0);

            cacheMap.put(key, temp);
        }
    }

    public int getLFUKey() {
        int key = 0;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
            if (minFreq > entry.getValue().frequency) {
                key = entry.getKey();
                minFreq = entry.getValue().frequency;
            }
        }
        return key;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) // cache hit
        {
            CacheEntry temp = cacheMap.get(key);
            temp.frequency++;
            cacheMap.put(key, temp);
            return temp.data;
        }
        return -1; // cache miss
    }

    public static boolean isFull() {
        if (cacheMap.size() == initialCapacity)
            return true;

        return false;
    }

    // display contents of cache
    public void display() {
        for (Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        LFUCache cache = new LFUCache(4);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.put(4, 4);
        cache.put(5, 5);
        cache.put(6, 6);
        cache.get(3);
        cache.put(7, 7);
        cache.get(6);
        cache.get(1);

        System.out.println(cache.get(1));
        cache.display();

    }
}
