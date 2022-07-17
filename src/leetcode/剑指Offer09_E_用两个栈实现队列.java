package leetcode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * @author xiaoliang
 * @date 2021/11/23 16:18
 **/
public class 剑指Offer09_E_用两个栈实现队列 {

    /**
     * 思路：入队都入stackA，出队时先把stackA 导入stackB再出队，然后回到stackA
     */
    static class CQueue {
        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public CQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void appendTail(int value) {
            stackA.push(value);
        }

        public int deleteHead() {

            if (stackA.isEmpty()) {
                return -1;
            }
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
            int res = stackB.pop();
            while (!stackB.isEmpty()) {
                stackA.push(stackB.pop());
            }
            return res;
        }
    }
}
