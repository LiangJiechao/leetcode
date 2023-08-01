package leetcode.labuladong.la11monotonestack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 *
 * @author xiaoliang
 * @date 2022/02/25 15:29
 **/
public class La1_LC496_E_下一个更大元素I {

    /**
     * 单调栈：模板：逆序入栈，判断个子高矮，矮个子弹出，高个子进去
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] nextGreaterArr = nextGreaterElement(nums2);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nextGreaterArr[map.get(nums1[i])];
        }

        return res;
    }

    /**
     * 单调栈：模板：逆序入栈，判断个子高矮，矮个子弹出，高个子进去
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElement(int[] nums) {

        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逆序入栈，判断个子高矮，矮个子弹出，高个子进去
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        La1_LC496_E_下一个更大元素I obj = new La1_LC496_E_下一个更大元素I();
        int[] nums = {2, 1, 2, 4, 3};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums)));

    }
}
