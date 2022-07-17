package b;

import java.util.Stack;

/**
 * @description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * @author xiaoliang
 * @date 2021/6/24 21:13
 * @version 1.0
 */
public class TwoStackToQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 入队
    public void push(Integer node){
        stack1.push(node);

    }
    // 出队
    public Integer pop(){
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
