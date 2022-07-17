package changkao.zijie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoliang
 * @date 2022/03/29 16:58
 **/
public class LC146_M_LRU缓存 {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DeList {
        int size;
        Node head;
        Node tail;

        public DeList() {
            this.size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        public void addHead(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
            size--;
        }

        public Node removeLast() {
            if (head.next == tail) {// 或者size == 0
                return null;
            }
            Node toDel = tail.pre;
            remove(toDel);
            return toDel;
        }
    }

    /**
     * 1 <= capacity <= 3000
     * 0 <= key <= 10000
     * 0 <= value <= 105
     */
    class LRUCache {

        Map<Integer, Node> map;
        DeList deList;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.deList = new DeList();
            this.capacity = capacity;
        }

        public int get(int key) {
            // 如果不包含该key
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            deList.remove(node);
            deList.addHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                deList.remove(node);
                node.value = value;
                deList.addHead(node);

                map.put(key, node);
                return;
            }
            // 不包含，要新增
            if (capacity == deList.size) {
                // 容量满了，删除最后一个
                Node toDel = deList.removeLast();
                map.remove(toDel.key);
            }
            Node newNode = new Node(key, value);
            deList.addHead(newNode);
            map.put(key, newNode);
        }
    }

}
