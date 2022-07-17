package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 同理 LeetCode 567 题， LeetCode 第 438 题，LeetCode 第 3 题
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @author xiaoliang
 * @date 2022/01/05 21:52
 **/
public class LC76_H_最小覆盖子串 {

    /**
     * 思路：
     * 步骤一：不断增加j使滑动窗口增大，直到窗口包含了T的所有元素，need中所有元素的数量都小于等于0，同时needCnt也是0
     * 步骤二：不断增加i使滑动窗口缩小，直到碰到一个必须包含的元素A，此时记录长度更新结果
     * 步骤三：让i再增加一个位置，开始寻找下一个满足条件的滑动窗口
     * <p>
     * need可以用数组代替（如果只有字母的话）
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        // 记录需要的字符个数
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // l是当前窗口左边界，r是当前窗口右边界，min记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, min = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need.getOrDefault(c, 0) > 0) {
                count--;
            }
            need.put(c, need.getOrDefault(c, 0) - 1);

            //窗口中已经包含所有字符
            if (count == 0) {
                // 开始缩小窗口
                while (l < r && need.get(s.charAt(l)) < 0) {
                    //释放左边移动出窗口的字符
                    need.put(s.charAt(l), need.get(s.charAt(l)) + 1);
                    //指针右移
                    l++;
                }
                if (r - l + 1 < min) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    min = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need.put(s.charAt(l), need.get(s.charAt(l)) + 1);
                l++;
                count++;

            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public static String minWindow2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        //left是当前左边界，right是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int size = Integer.MAX_VALUE, count = t.length(), start = 0;
        int left = 0, right = 0;
        //遍历所有字符
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口

            while (count == 0) {//窗口中已经包含所有字符

                if (right - left < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = right - left;
                    start = left;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }

                char c1 = s.charAt(left);
                if (need[c1] == 0) {
                    count++;
                }
                need[c1]++;
                left++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow2(s, t));
    }
}
