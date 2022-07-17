package leetcode.labuladong.la11monotonestack;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * @author xiaoliang
 * @date 2022/02/25 16:59
 **/
public class La2_LC739_M_每日温度 {

    /**
     * 单调栈：模板：逆序入栈，判断个子高矮，矮个子弹出，高个子进去
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        // 存放元素的索引
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {

//                * 输入: temperatures = [73,74,75,71,69,72,76,73]
//                * 输出: [1,1,4,2,1,1,0,0]
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

}
