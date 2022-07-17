package leetcode.labuladong.la12monotonestackapp;

import java.util.Stack;

/**
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * 该题与 316 相同
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * @author xiaoliang
 * @date 2022/02/28 09:06
 **/
public class La2_LC1081_M_不同字符的最小子序列 {

    public String smallestSubsequence(String s) {

        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        int[] set = new int[26];

        for (char c : arr) {
            if (set[c - 'a'] == 0) {

                while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                    Character pop = stack.pop();
                    set[pop - 'a'] = 0;
                }
                stack.push(c);
                set[c - 'a'] = 1;
            }
            count[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }
}
