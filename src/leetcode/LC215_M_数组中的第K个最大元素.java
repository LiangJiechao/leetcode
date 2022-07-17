package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author xiaoliang
 * @date 2021/11/05 20:06
 **/
public class LC215_M_数组中的第K个最大元素 {

    /**
     * 用大小为k的小根堆
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        // 大小为k的小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (heap.size() >= k) {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.offer(num);
                }
            } else {
                heap.offer(num);
            }
        }
        return heap.stream().min(Comparator.comparingInt(o -> o)).get();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }
}
