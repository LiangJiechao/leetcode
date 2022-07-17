package leetcode.labuladong.la12monotonestackapp;

import java.util.Stack;

/**
 * 单调栈的应用
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * @author xiaoliang
 * @date 2022/02/28 09:04
 **/
public class La1_LC316_M_去除重复字母 {

    /**
     * 单调栈的应用
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
//        Set<Character> set = new HashSet<>();
        int[] set = new int[26];

        for (char c : arr) {
            // 栈中没有才加入
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
