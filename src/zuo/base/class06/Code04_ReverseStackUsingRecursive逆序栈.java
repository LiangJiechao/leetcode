package zuo.base.class06;

import java.util.Stack;

/**
 * 递归实现：给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能使用递归函数。 如何实现?
 *
 * @author xiaoliang
 * @date 2021/09/16 16:14
 **/
public class Code04_ReverseStackUsingRecursive逆序栈 {

    /**
     * 递归实现：
     * 逆序这个栈
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack){

        if(stack==null || stack.isEmpty()){
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(last);
    }

    /**
     * 递归实现：
     * 从栈中拿到并移除最后一个元素
     * @param stack
     * @return
     */
    public static Integer getAndRemoveLastElement(Stack<Integer> stack) {

        int res = stack.pop();
        if (stack.empty()) {
            return res;
        }

        int last = getAndRemoveLastElement(stack);
        stack.push(res);
        return last;

    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        reverseStack(stack);

        stack.forEach(System.out::println);

    }
}
