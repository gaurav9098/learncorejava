package com.gt.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl extends LinkedHashMap<Integer, String> {
	private static final long serialVersionUID = 1L;
	private int capacity;

	public LRUCacheImpl(int capacity, float loadFactor) {
		super(capacity, loadFactor, true);
		this.capacity = capacity;
	}

	/**
	 * removeEldestEntry() should be overridden by the user, otherwise it will
	 * not remove the oldest object from the Map.
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
		return size() > this.capacity;
	}

	/*
	 * 
	 * println() method prints object in order of their staleness. As you can
	 * see in the above code, Object1, Object2 and Object3 are inserted and
	 * object1 is accessed just before inserting the Object4 and hence Object1
	 * is printed before the object4 in the first line of the output. When
	 * Object5 is inserted the Object2 is get evicted from the list because this
	 * object is the oldest in the list. When object3 is accessed, it gets
	 * promoted higher than object5 and when object6 is inserted Object1 is
	 * evicted. The rest output is self-explanatory, hope you will not find
	 * difficult in understanding the output.
	 */

	public static void main(String arg[]) {
		LRUCacheImpl lruCache = new LRUCacheImpl(4, 0.75f);

		lruCache.put(1, "Object1");
		lruCache.put(2, "Object2");
		lruCache.put(3, "Object3");
		lruCache.get(1);
		lruCache.put(4, "Object4");
		System.out.println(lruCache);
		lruCache.put(5, "Object5");
		lruCache.get(3);
		lruCache.put(6, "Object6");
		System.out.println(lruCache);
		lruCache.get(4);
		lruCache.put(7, "Object7");
		lruCache.put(8, "Object8");
		System.out.println(lruCache);
	}
}