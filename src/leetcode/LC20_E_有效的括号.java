package leetcode;

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
public class LC20_E_有效的括号 {

    public static boolean isValid(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        int time = s.length() / 2;
        for (int i = 0; i < time; i++) {

            s = s.replace("{}", "").replace("()", "").replace("[]", "");
        }
        return s.length() == 0;
    }

    public static boolean isValid1(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                switch (c) {
                    case ')':
                        if (pop == '(') {
                            break;
                        } else {
                            return false;
                        }

                    case ']':
                        if (pop == '[') {
                            break;
                        } else {
                            return false;
                        }
                    case '}':
                        if (pop == '{') {
                            break;
                        } else {
                            return false;
                        }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

}
