package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * @author xiaoliang
 * @date 2021/12/10 10:50
 **/
public class 剑指Offer40_E_最小的k个数 {

    /**
     * 用堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int item : arr) {
            minHeap.offer(item);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    /**
     * 用流
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }
}
