package b;

import java.util.ArrayDeque;

/**
 * 最长括号匹配
 */
public class ValidParentheses {

    //暴力解法
    public static int validParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        //栈
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int tmpMax = 0;
            stack.clear();//清楚为本次括号的服务
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '(') {// 为 (
                    stack.push('(');
                    tmpMax++;
                } else {// 为 )
                    if (stack.size() < 1) {
                        //栈为空，匹配就结束了
                        max = max < tmpMax ? tmpMax : max;
                        break;
                    } else {
                        stack.pop();
                        tmpMax++;
                    }
                }
            }
            if (stack.size() == 0) {
                max = max < tmpMax ? tmpMax : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(validParentheses(")()()(())"));//  8
        System.out.println(validParentheses("((((((((("));//  0
        System.out.println(validParentheses(")()())"));//  4
    }
}
