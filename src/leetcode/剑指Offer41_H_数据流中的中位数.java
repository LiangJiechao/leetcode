package leetcode;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * @author xiaoliang
 * @date 2021/12/10 10:58
 **/
public class 剑指Offer41_H_数据流中的中位数 {

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    /**
     * 思路：
     * 大小根堆相互配合
     * 在数字流中，持续获得中位数
     * 步骤：
     * ①有数进来，如果大根堆为空，则进大根堆，或者数小于大根堆堆顶，也进大根堆；否则进小根堆；
     * 若进入后，两堆之差 >1，则多的那个弹出堆顶到另一个堆中；
     * 这样一来，中位数 = 奇数时多个那个堆的堆顶，偶数时为两堆堆顶相加除2
     */
    class MedianFinder {
        private PriorityQueue<Integer> largeHeap;
        private PriorityQueue<Integer> smallHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            largeHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            smallHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (largeHeap.isEmpty() || num < largeHeap.peek()) {
                largeHeap.offer(num);
            } else {
                smallHeap.offer(num);
            }

            if (largeHeap.size() - smallHeap.size() == 2) {
                smallHeap.offer(largeHeap.poll());
            } else if (smallHeap.size() - largeHeap.size() == 2) {
                largeHeap.offer(smallHeap.poll());
            }

        }

        public double findMedian() {
            if (largeHeap.isEmpty() && smallHeap.isEmpty()) {
                // 堆中无数
                return 0;
            }
            int largeHeapSize = largeHeap.size();
            int smallHeapSize = smallHeap.size();
            if (largeHeapSize == smallHeapSize) {
                return 1.0 * (largeHeap.peek() + smallHeap.peek()) / 2;
            } else if (largeHeapSize == smallHeapSize + 1) {
                return largeHeap.peek();
            } else {
                return smallHeap.peek();
            }
        }
    }

}
