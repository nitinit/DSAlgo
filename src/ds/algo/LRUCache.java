package ds.algo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	// store keys of cache
	private Deque<Integer> doublyQueue;

	// store references of key in cache
	private HashMap<Integer, Integer> hashMap;

	// maximum capacity of cache
	private final int CACHE_SIZE;

	LRUCache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashMap = new HashMap<>();
		CACHE_SIZE = capacity;
	}

	/* Refer the page within the LRU cache */
	public void put(int key, int value) {
		if (hashMap.containsKey(key)) {
			doublyQueue.remove(key);
			hashMap.remove(key);
		} else {
			if (doublyQueue.size() >= CACHE_SIZE) {
				int element = doublyQueue.removeLast();
				System.out.println("Remove:" + hashMap.remove(element));
			}
		}
		hashMap.put(key, value);
		doublyQueue.push(key);
	}

	public int get(int key) {
		if (hashMap.containsKey(key)) {
			doublyQueue.remove(key);
			doublyQueue.push(key);
			return hashMap.get(key);
		}
		return -1;
	}

	// display contents of cache
	public void display() {
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			System.out.print(entry.getKey() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.get(1);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6);
		cache.get(1);
		cache.put(7, 7);
		cache.put(2, 2);
		cache.put(5, 5);
		cache.put(2, 2);
		cache.get(1);

		System.out.println(cache.get(1));
		cache.display();
	}
}
