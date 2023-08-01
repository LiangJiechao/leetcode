package leetcode.labuladong.la13lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) 
 * - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。
 * 当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 *
 * @author xiaoliang
 * @date 2022/02/28 09:09
 **/
public class La2_LFUCache {

    static class LFUCache {

        Map<Integer, Integer> keyToVal;
        Map<Integer, Integer> keyToFreq;
        Map<Integer, LinkedHashSet<Integer>> freqToKeys;
        int minFreq;
        int size;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            minFreq = 0;
            this.size = capacity;

        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            increaseFreq(key);
            return keyToVal.get(key);
        }

        /*["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]*/
        public void put(int key, int value) {
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);

                increaseFreq(key);
                return;
            }
            // 不存在，是新的key
            // 满了，移除一个key
            if (keyToVal.size() >= size) {
                removeMinFreqKey();
            }

            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            minFreq = 1;
        }

        private void removeMinFreqKey() {
            LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
            // 其中最先被插入的那个 key 就是该被淘汰的 key
            int deletedKey = keyList.iterator().next();
            keyList.remove(deletedKey);
            if (keyList.isEmpty()) {
                freqToKeys.remove(minFreq);
                // 问：这里需要更新 minFreq 的值吗？ 不用
            }

            keyToVal.remove(deletedKey);
            keyToFreq.remove(deletedKey);
        }

        private void increaseFreq(int key) {
            Integer oldFreq = keyToFreq.get(key);
            keyToFreq.put(key, oldFreq + 1);

            LinkedHashSet<Integer> oldFreqSet = freqToKeys.get(oldFreq);
            oldFreqSet.remove(key);
            if (oldFreqSet.isEmpty()) {
                freqToKeys.remove(oldFreq);
                // 更新minFreq
                if (minFreq == oldFreq) {
                    minFreq++;
                }
            }

            freqToKeys.putIfAbsent(oldFreq + 1, new LinkedHashSet<>());
            freqToKeys.get(oldFreq + 1).add(key);
        }

    }

    public static void main(String[] args) {
         /*["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]*/
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();


        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in));){
            String s = input.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
