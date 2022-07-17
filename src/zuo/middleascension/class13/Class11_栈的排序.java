package zuo.middleascension.class13;

import java.util.Stack;

/**
 * 给定一个无序的栈，要求只通过一个辅助栈完成栈的排序
 * @author xiaoliang
 * @date 2021/09/25 10:54
 **/
public class Class11_栈的排序 {

    public static void sortStack(Stack<Integer> stack){

        if (stack==null||stack.isEmpty()){
            return;
        }
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            // 使得help栈中的顺序： 栈顶的最大
            while (!help.isEmpty() && pop < help.peek()){
                stack.push(help.pop());
            }
            help.push(pop);
        }
        // 放回原栈
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(9);
        stack.push(4);
        stack.push(7);
        stack.push(2);
        stack.push(6);
        stack.push(4);

        sortStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
