package zuo.base.class05;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 大小根堆相互配合
 * 在数字流中，持续获得中位数
 * 步骤：
 * ①有数进来，如果大根堆为空，则进大根堆，或者数小于大根堆堆顶，也进大根堆；否则进小根堆；
 * 若进入后，两堆之差 >1，则多的那个弹出堆顶到另一个堆中；
 * 这样一来，中位数 = 奇数时多个那个堆的堆顶，偶数时为两堆堆顶相加除2
 *
 * @author xiaoliang
 * @date 2021/09/16 16:09
 **/
public class Code06_FindMiddleNumber大小根堆相互配合 {

    static Queue<Integer> largeHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static Queue<Integer> smallHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

    public static int getMiddleNumber() {
        if (largeHeap.isEmpty() && smallHeap.isEmpty()) {
            // 堆中无数
            return 0;
        }
        int largeHeapSize = largeHeap.size();
        int smallHeapSize = smallHeap.size();
        if (largeHeapSize == smallHeapSize) {
            return (largeHeap.peek() + smallHeap.peek()) / 2;
        } else if (largeHeapSize == smallHeapSize + 1) {
            return largeHeap.peek();
        } else {
            return smallHeap.peek();
        }
    }

    public static void setArrayNumber(int[] arr) {

        for (int number : arr) {
            if (largeHeap.size() == 0 || number <= largeHeap.peek()) {
                largeHeap.offer(number);
            } else {
                smallHeap.offer(number);
            }

            if (largeHeap.size() - smallHeap.size() == 2) {
                smallHeap.offer(largeHeap.poll());
            } else if (smallHeap.size() - largeHeap.size() == 2) {
                largeHeap.offer(smallHeap.poll());
            }
        }
    }

    public static void main(String[] args) {
        setArrayNumber(new int[]{6, 1, 2, 10, 3, 4, 8});
        int middleNumber = getMiddleNumber();
        System.out.println("middleNumber = " + middleNumber);
    }
}
