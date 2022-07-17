package zuo.baseascension.class07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 * boolean isSameSet(a,b) ==> O(1)
 * void union(a,b) ==> O(1)
 *
 * @author xiaoliang
 * @date 2021/09/18 15:02
 **/
public class Code04_UnionFind {

    static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    static class UnionFindSet<V> {
        //1.记录包裹自己一层的类
        //2.记录自己的父节点
        //3.如果自己就是父节点，记录自己的子节点个数
        private HashMap<V, Element<V>> elementMap;
        private HashMap<Element<V>, Element<V>> fatherMap;
        private HashMap<Element<V>, Integer> sizeMap;

        // 构造函数
        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V item : list) {
                Element<V> element = new Element<>(item);
                elementMap.put(item, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSameSet(V v1, V v2) {
            if (!elementMap.containsKey(v1) || !elementMap.containsKey(v2)) {
                return false;
            }
            return findFather(elementMap.get(v1)) == findFather(elementMap.get(v2));
        }

        public void union(V v1, V v2) {
            if (!isSameSet(v1, v2)) {
                Element<V> f1 = findFather(elementMap.get(v1));
                Element<V> f2 = findFather(elementMap.get(v2));

                Integer size1 = sizeMap.get(f1);
                Integer size2 = sizeMap.get(f2);

                Element<V> big = size1 > size2 ? f1 : f2;
                Element<V> small = big == f1 ? f2 : f1;

                fatherMap.put(small, big);
                Integer smallSize = sizeMap.get(small);
                sizeMap.put(big, sizeMap.get(big) + smallSize);
                sizeMap.remove(small);
            }
        }

        public Element<V> findFather(Element<V> element) {
            Stack<Element> stack = new Stack<>();
            while (element != fatherMap.get(element)) {
                stack.push(element);
                element = fatherMap.get(element);
            }
            // 把沿途找到的元素
            for (Element ele : stack) {
                fatherMap.put(ele, element);
                sizeMap.put(element, sizeMap.get(element) + 1);
            }
            return element;
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
        boolean sameSet2 = unionFindSet.isSameSet(3, 4);
        System.out.println("sameSet2 = " + sameSet2);

    }
}
