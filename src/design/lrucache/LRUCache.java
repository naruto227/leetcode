package design.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * 链接：https://leetcode-cn.com/problems/lru-cache/
 * 注：LinkedHashMap查源码及用法、增加双向链表的方法
 * Created by Michael Allan on 2020/5/25.
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
