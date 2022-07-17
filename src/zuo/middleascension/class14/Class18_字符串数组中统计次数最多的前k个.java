package zuo.middleascension.class14;

import java.util.*;

/**
 * 给定一个字符串类型的数组，求其中出现次数最多的前k个
 * 方法1：大根堆：全部字符都插进大根堆，弹出的前k个就是次数最多的前k个
 * 方法2：k个大小的小根堆：用一个map保存字符对应出现的记录数，每扫过一个字符，就判断其记录数是否比小根堆堆顶的元素大，
 * 是则弹出堆顶，插入该元素，以此类推
 *
 * @author xiaoliang
 * @date 2021/09/26 14:28
 **/
public class Class18_字符串数组中统计次数最多的前k个 {

    // 大根堆，写得好像有点复制
    public static List<String> getCountMoreK1(String[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k) {
            throw new RuntimeException("参数错误");
        }
        class Node {
            String element;
            Integer count;

            public Node(String ele, Integer cnt) {
                element = ele;
                count = cnt;
            }
        }

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> {
            return o2.count - o1.count;
        });

        Map<String, Integer> map = new HashMap<>();

        for (String item : arr) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            }
            map.put(item, map.get(item) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < k; i++) {
            list.add(maxHeap.poll().element);
        }
        return list;
    }

    // 小根堆
    public static List<String> getCountMoreK2(String[] arr, int k) {
        if (arr == null || arr.length == 0 || arr.length < k) {
            throw new RuntimeException("参数错误");
        }


        Map<String, Integer> map = new HashMap<>();
        for (String item : arr) {
            map.put(item, map.getOrDefault(item,0) + 1);
        }

        // 规定堆的容量
        PriorityQueue<String> minHeap = new PriorityQueue<>(k);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                // 里面元素不够时，直接进入
                minHeap.add(entry.getKey());
            } else if (map.get(minHeap.peek()) < entry.getValue()) {
                // 判断元素小于堆顶，可以替换该堆顶元素
                minHeap.poll();
                minHeap.add(entry.getKey());
            }
        }

        return new ArrayList<String>(minHeap);
    }

    public static void main(String[] args) {
        String[] arr = {"c", "b", "a", "a", "a", "c", "d", "d", "d", "d", "f", "e"};
        for (String item : getCountMoreK2(arr, 3)) {
            System.out.println(item);
        }
    }
}
