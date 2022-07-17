package zuo.baseascension.class08;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 单调栈的应用，滑动窗口记录每个窗口的最大值
 * @author xiaoliang
 * @date 2021/09/19 20:38
 **/
public class Code03_滑动窗口SlidingWindowMaxArray {

    /**
     * 获得由每个窗口最大值组成的数组
     *
     * @param arr 原始数组
     * @param w   窗口大小
     * @return
     */
    public static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || arr.length == 0 || w < 1) {
            return null;
        }
        //双端队列 维持的信息是 某一时刻，窗口不扩，依次往右动，谁会成为最大值的优先级信息
        Deque<Integer> deque = new LinkedList<>();
        // 记录每个窗口的最大值
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // 因为要满足双端队列中的元素严格单调递减
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 时刻保存队列里面是有w个数，抽象的数
            if(deque.peekFirst() == i - w){
                deque.pollFirst();
            }
            // 当i到窗口大小后就开始每次滑动都要记录，就是每个窗口的最大值
            if (i >= w-1){
                res.add(arr[deque.peekFirst()]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7 };
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        for (int i : maxWindow) {
            System.out.print(" " + i);
        }
    }


}
