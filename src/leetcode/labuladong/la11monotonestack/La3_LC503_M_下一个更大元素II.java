package leetcode.labuladong.la11monotonestack;

import java.util.Stack;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 *
 * @author xiaoliang
 * @date 2022/02/25 17:06
 **/
public class La3_LC503_M_下一个更大元素II {

    /**
     * 单调栈：模板：逆序入栈，判断个子高矮，矮个子弹出，高个子进去
     * 当然也可以构造新的数组2倍的nums
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }

}
