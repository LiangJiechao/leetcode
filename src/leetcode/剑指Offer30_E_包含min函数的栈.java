package leetcode;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author xiaoliang
 * @date 2021/11/23 17:32
 **/
public class 剑指Offer30_E_包含min函数的栈 {

    /**
     * 思路：用两个栈，一个记录正常的栈序列，另一个记录当前栈中的最小值
     */
    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(minStack.peek(), x));
            }

        }

        public void pop() {
            if (stack.isEmpty()){
                return;
            }
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
