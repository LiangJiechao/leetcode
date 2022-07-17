package zuo.baseascension.class07;

import java.util.*;

/**
 * 并查集
 * boolean isSameSet(a,b) ==> O(1)
 * void union(a,b) ==> O(1)
 *
 * @author xiaoliang
 * @date 2021/09/18 15:02
 **/
public class Code04_UnionFind链表实现 {

    static class Node<T> {
        T element;
        Node<T> father;

        public Node(T element) {
            this.element = element;
            this.father = this;
        }
    }

    static class UnionFindSet<T> {
        Map<T, Node<T>> map = new HashMap<>();

        public UnionFindSet(List<T> list) {
            for (T item : list) {
                map.put(item, new Node<T>(item));
            }
        }

        public boolean isSameSet(T v1, T v2) {
            if (v1 == null || v2 == null || !map.containsKey(v1) || !map.containsKey(v2)) {
                return false;
            }
            Node<T> node1 = map.get(v1);
            Node<T> node2 = map.get(v2);
            return findFather(node1) == findFather(node2);
        }

        /**
         * 合并时，v1和v2代表的是他所在的集合
         * @param v1
         * @param v2
         */
        public void union(T v1, T v2) {
            if (!isSameSet(v1, v2)) {
                Node<T> f1 = findFather(map.get(v1));
                Node<T> f2 = findFather(map.get(v2));
                // 这里没有记录大小，所以默认node1加入node2
                f1.father = f2;
            }
        }

        public Node<T> findFather(Node node) {

            Stack<Node<T>> stack = new Stack<>();
            while (node != node.father) {
                stack.push(node);
                node = node.father;
            }
            for (Node<T> item : stack) {
                item.father = node;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        UnionFindSet<Integer> unionFindSet = new UnionFindSet<>(Arrays.asList(1, 3, 4, 5, 6, 7));

        boolean sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);

        unionFindSet.union(1, 4);
        sameSet = unionFindSet.isSameSet(1, 4);
        System.out.println("sameSet = " + sameSet);

        unionFindSet.union(5, 3);
        unionFindSet.union(3, 6);
        boolean sameSet1 = unionFindSet.isSameSet(3, 4);
        System.out.println("sameSet1 = " + sameSet1);
        unionFindSet.union(3, 4);
        boolean sameSet2 = unionFindSet.isSameSet(6, 4);
        System.out.println("sameSet2 = " + sameSet2);
    }
}
