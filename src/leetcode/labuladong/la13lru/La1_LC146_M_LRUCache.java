package leetcode.labuladong.la13lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 
 * 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author xiaoliang
 * @date 2022/02/26 21:14
 **/
public class La1_LC146_M_LRUCache {

    class Node<K, V> {
        K key;
        V value;
        Node prev;
        Node next;

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 思路：用双向链表
     * 每次新添加或查看就把该节点放到链表头
     * 若超出容量需要淘汰就丢弃链表尾的节点
     */
    class DeList<K, V> {
        int size;
        Node<K, V> head;
        Node<K, V> tail;

        public DeList() {
            size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        // 添加到头部
        public void addHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }

        // 删除链表中的 x 节点（x ⼀定存在）
        // 由于是双链表且给的是⽬标 Node 节点，时间 O(1)
        public void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        // 删除链表中最后⼀个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            if (head.next == tail) {// 或者size == 0
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }

    }

    class LRUCache {
        // 双向链表，用来维护key的排序
        DeList<Integer, Integer> deList;
        Map<Integer, Node<Integer, Integer>> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.deList = new DeList<>();
            this.map = new HashMap<>();
        }

        public int get(int key) {
            // 如果不包含该key
            if (!map.containsKey(key)) {
                return -1;
            }
            // 更新到头部
            deList.remove(map.get(key));
            deList.addHead(map.get(key));
            return map.get(key).value;
        }

        public void put(int key, int value) {
            // 如果包含该key
            if (map.containsKey(key)) {
                Node<Integer, Integer> node = map.get(key);
                // 2更新双向链表中key的排序，放到链表头
                deList.remove(node);
                node.value = value;
                deList.addHead(node);
                // 1更新值
                map.put(key, node);
                return;
            }
            // 不包含，要新增
            if (deList.size() == capacity) {
                // 满了，要先淘汰
                Node node = deList.removeLast();
                map.remove(node.key);
            }
            Node<Integer, Integer> newNode = new Node<>(key, value);
            deList.addHead(newNode);
            map.put(key, newNode);
        }
    }
}
