package leetcode.labuladong.la13lru;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * https://mp.weixin.qq.com/s/oXv03m1J8TwtHwMJEZ1ApQ
 * 可以看看算法实现，主要还是那三个map  和 freqToKeys 中的 LinkedHashSet
 * <p>
 * LFU 算法相当于是把数据按照访问频次进⾏排序，这个需求恐怕没有那么简单，⽽且还有⼀种情况，如果
 * 多个数据拥有相同的访问频次，我们就得删除最早插⼊的那个数据。也就是说 LFU 算法是淘汰访问频次最低
 * 的数据，如果访问频次最低的数据有多条，需要淘汰最旧的数据。
 *
 * @author xiaoliang
 * @date 2022/02/26 22:45
 **/
public class La2_LC460_H_LFUCache {

    class LFUCache {
        // key 到 val 的映射，我们后文称为 KV 表
        HashMap<Integer, Integer> keyToVal;
        // key 到 freq 的映射，我们后文称为 KF 表
        HashMap<Integer, Integer> keyToFreq;
        // freq 到 key 列表的映射，我们后文称为 FK 表
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        // 记录最小的频次
        int minFreq;
        // 记录 LFU 缓存的最大容量
        int capacity;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            this.capacity = capacity;
            this.minFreq = 0;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            // 增加 key 对应的 freq
            increaseFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int val) {
            if (this.capacity <= 0) {
                return;
            }

            /* 若 key 已存在，修改对应的 val 即可 */
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, val);
                // key 对应的 freq 加一
                increaseFreq(key);
                return;
            }

            /* key 不存在，需要插入 */
            /* 容量已满的话需要淘汰一个 freq 最小的 key */
            if (this.capacity <= keyToVal.size()) {
                removeMinFreqKey();
            }

            /* 插入 key 和 val，对应的 freq 为 1 */
            // 插入 KV 表
            keyToVal.put(key, val);
            // 插入 KF 表
            keyToFreq.put(key, 1);
            // 插入 FK 表
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            // 插入新 key 后最小的 freq 肯定是 1
            this.minFreq = 1;
        }

        private void removeMinFreqKey() {
            // freq 最小的 key 列表
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            // 其中最先被插入的那个 key 就是该被淘汰的 key
            int deletedKey = keyList.iterator().next();
            /* 更新 FK 表 */
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKeys.remove(this.minFreq);
                // 问：这里需要更新 minFreq 的值吗？ 不用
            }
            /* 更新 KV 表 */
            keyToVal.remove(deletedKey);
            /* 更新 KF 表 */
            keyToFreq.remove(deletedKey);
        }

        private void increaseFreq(int key) {
            int freq = keyToFreq.get(key);
            /* 更新 KF 表 */
            keyToFreq.put(key, freq + 1);

            /* 更新 FK 表 */
            // 将 key 从 freq 对应的列表中删除
            freqToKeys.get(freq).remove(key);
            // 如果 freq 对应的列表空了，移除这个 freq
            if (freqToKeys.get(freq).isEmpty()) {
                freqToKeys.remove(freq);
                // 如果这个 freq 恰好是 minFreq，更新 minFreq
                if (freq == this.minFreq) {
                    this.minFreq++;
                }
            }

            // 将 key 加入 freq + 1 对应的列表中
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);
        }

    }

}
