package zuo.base.class02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 堆排序扩展题目 已知一个几乎有序的数组，几乎有序
 * 是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的 排序算法针对这个数据进行排序。
 *
 * @author xiaoliang
 * @date 2021/09/12 15:45
 **/
public class Code04_SortArrayDistanceLessK {
    /**
     * 小跟堆的应用
     * 时间复杂度 O(N*logK)
     *
     * @param arr
     * @param k
     */
    public static void sortArrayDistanceLessK(int[] arr, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int index = 0;
        // 如k=3，则priorityQueue先放进3个元素
        while (index < Math.min(arr.length, k)) {
            priorityQueue.add(arr[index++]);
        }

        int i =0;
        while (index<arr.length){
            priorityQueue.add(arr[index++]);
            arr[i++] = priorityQueue.poll();
        }
        while (!priorityQueue.isEmpty()){
            arr[i++] = priorityQueue.poll();
        }
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 4, 5, 3, 6, 7, 3, 5};
        sortArrayDistanceLessK(arr, 5);
        System.out.println(Arrays.toString(arr));

    }
}
