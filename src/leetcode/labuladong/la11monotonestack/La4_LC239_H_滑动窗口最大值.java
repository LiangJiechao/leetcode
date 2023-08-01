package leetcode.labuladong.la11monotonestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 *
 * @author xiaoliang
 * @date 2022/02/25 19:47
 **/
public class La4_LC239_H_滑动窗口最大值 {

    // 队列型滑动窗口
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 双向队列 记录 `下标`
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);

            // 时刻保持窗口大小为 k
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // 达到窗口大小，开始记录
            if (i >= k - 1) {
                res[index] = nums[deque.peekFirst()];
                index++;
            }

        }
        return res;
    }

}
