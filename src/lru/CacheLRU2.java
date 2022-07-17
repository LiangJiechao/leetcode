package lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现cache的LRU算法（手动实现，不使用 LinkedHashMap）
 *
 * @author xiaoliang
 * @date 2021/08/20 10:18
 **/
public class CacheLRU2<K, V> {

    // map 负责查找，构建一个虚拟的双向链表，它里面安放的是一个个Node节点，作为数据载体。

    //1 构造一个Node节点，作为数据载体
    class Node<K, V> {
        K key;
        V val;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            prev = null;
            next = null;
        }

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    //构建一个双向列表，里面存放的是Node
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        // 初始化双向链表
        public DoubleLinkedList() {
            head = new Node<K, V>();
            tail = new Node<K, V>();
            head.next = tail;
            head.prev = tail;
            tail.next = head;
            tail.prev = head;
        }

        // 添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 删除节点
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        // 获取最后一个节点
        public Node<K, V> getLastNode() {
            return tail.prev;
        }

        // 简单查看现在的顺序
        public List<K> keyset() {
            ArrayList<K> keyList = new ArrayList<>();
            Node<K, V> p = head.next;
            while (true) {
                K key = p.key;
                if (key == null) {// 证明到尾巴了
                    break;
                }
                keyList.add(key);
                p = p.next;
            }

            return keyList;
        }
    }

    private int capacity;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public CacheLRU2(int capacity) {
        this.capacity = capacity; //容量
        this.map = new HashMap<>(); //查找
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) { //update
            Node<Integer, Integer> node = map.get(key);
            node.val = val;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {// save
            if (map.size() == capacity) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLastNode();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            Node<Integer, Integer> newNode = new Node<>(key, val);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        CacheLRU2 cacheLRU = new CacheLRU2(3);
        cacheLRU.put(1, 1);
        cacheLRU.put(2, 2);
        cacheLRU.put(3, 3);
        System.out.println(cacheLRU.doubleLinkedList.keyset());

        cacheLRU.put(4, 4);
        System.out.println(cacheLRU.doubleLinkedList.keyset());

        cacheLRU.put(3, 3);
        System.out.println(cacheLRU.doubleLinkedList.keyset());
        cacheLRU.put(3, 3);
        System.out.println(cacheLRU.doubleLinkedList.keyset());
        cacheLRU.put(3, 3);
        System.out.println(cacheLRU.doubleLinkedList.keyset());
        cacheLRU.put(5, 5);
        System.out.println(cacheLRU.doubleLinkedList.keyset());

        System.out.println("remove Last ");
        cacheLRU.doubleLinkedList.removeNode(cacheLRU.doubleLinkedList.getLastNode());
        System.out.println(cacheLRU.doubleLinkedList.keyset());

    }

}

/*
[3, 2, 1]
[4, 3, 2]
[3, 4, 2]
[3, 4, 2]
[3, 4, 2]
[5, 3, 4]
remove Last
[5, 3]
* */

