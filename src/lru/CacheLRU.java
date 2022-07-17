package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现cache的LRU算法
 * @author xiaoliang
 * @date 2021/08/20 10:18
 **/
public class CacheLRU<K,V> extends LinkedHashMap<K, V> {

    private int capacity;

    public CacheLRU(int capacity) {
        // * @param  accessOrder     the ordering mode -
        // <tt>true</tt> for access-order,
        // <tt>false</tt> for insertion-order
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    //什么时候淘汰
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }


    public static void main(String[] args) {
        CacheLRU cacheLRU = new CacheLRU(3);
        cacheLRU.put(1,"a");
        cacheLRU.put(2,"b");
        cacheLRU.put(3,"c");
        System.out.println(cacheLRU.keySet());

        cacheLRU.put(4,"e");
        System.out.println(cacheLRU.keySet());

        cacheLRU.put(3,"c");
        System.out.println(cacheLRU.keySet());
        cacheLRU.put(3,"c");
        System.out.println(cacheLRU.keySet());
        cacheLRU.put(3,"c");
        System.out.println(cacheLRU.keySet());
        cacheLRU.put(5,"f");
        System.out.println(cacheLRU.keySet());
    }
}

/* true 按照访问顺序淘汰
[1, 2, 3]
[2, 3, 4]
[2, 4, 3]
[2, 4, 3]
[2, 4, 3]
[4, 3, 5]
* */

/* false 按照插入顺序淘汰
[1, 2, 3]
[2, 3, 4]
[2, 3, 4]
[2, 3, 4]
[2, 3, 4]
[3, 4, 5]
* */
