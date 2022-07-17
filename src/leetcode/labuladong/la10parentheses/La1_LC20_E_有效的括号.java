package leetcode.labuladong.la10parentheses;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * @author xiaoliang
 * @date 2021/11/05 09:54
 **/
public class La1_LC20_E_有效的括号 {

    public boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 字符 c 是右括号
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return stack.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        }
        return '{';
    }

}
