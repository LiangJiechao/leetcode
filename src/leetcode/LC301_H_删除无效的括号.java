package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 示例 1：
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * <p>
 * 示例 2：
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 *
 * @author xiaoliang
 * @date 2022/04/08 10:53
 **/
public class LC301_H_删除无效的括号 {

    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {

        char[] arr = s.toCharArray();

        int lremove = 0;
        int rremove = 0;

        for (char ch : arr) {
            if (ch == '(') {
                lremove++;
            } else if (ch == ')') {
                if (lremove <= 0) {
                    rremove++;
                } else {
                    lremove--;
                }
            }
        }

        helper(s, 0, lremove, rremove);
        return res;
    }

    public void helper(String s, int startIndex, int lremove, int rremove) {

        if (lremove == 0 && rremove == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (lremove + rremove > s.length()) {
                return;
            }

            if (s.charAt(i) == '(' && lremove > 0) {
                helper(s.substring(0, i) + s.substring(i + 1, s.length()), i, lremove - 1, rremove);
            }
            if (s.charAt(i) == ')' && rremove > 0) {
                helper(s.substring(0, i) + s.substring(i + 1, s.length()), i, lremove, rremove - 1);
            }

        }

    }

    public boolean isValid(String s) {
        int cnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                if (cnt > 0) {
                    cnt--;
                } else {
                    return false;
                }
            }
        }
        return cnt == 0;

    }

    public static void main(String[] args) {
        System.out.println(new LC301_H_删除无效的括号().removeInvalidParentheses(")("));
    }
}
