package b;

import java.util.Stack;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 栈的压入, 弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
 * @date 2021/6/24 21:23
 */
public class IsStackPopOrder {

    public boolean isStackPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }

        return stack.empty();
    }
}
