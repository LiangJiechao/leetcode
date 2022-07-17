package leetcode.labuladong.la9queuestatck;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * @author xiaoliang
 * @date 2022/02/25 11:32
 **/
public class La1_LC232_E_用栈实现队列 {

    class MyQueue {

        // 或者用 Deque--> LinkedList
        Stack<Integer> s1;
        Stack<Integer> s2;

        /**
         * 思路：
         * s1用来保存入队元素
         * s2负责出队
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            // 先调用 peek 保证 s2 非空
            peek();
            return s2.pop();
        }

        public int peek() {
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

}
