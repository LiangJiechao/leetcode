package leetcode.labuladong.la3slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * s1 和 s2 仅包含小写字母
 *
 * @author xiaoliang
 * @date 2022/01/06 09:09
 **/
public class LC567_M_字符串的排列 {
    /**
     * 思路：
     * 滑动窗口 数组写法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        // s1 和 s2 仅包含小写字母
        int[] need = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int count = s1.length();
        int left = 0, right = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need[c - 'a'] > 0) {
                count--;
            }
            need[c - 'a']--;

            while (count == 0) {
                //  s1= "ab", s2 = "eidbaooo"
                if (right - left == s1.length()) {
                    return true;
                }

                char c1 = s2.charAt(left);
                left++;
                if (need[c1 - 'a'] == 0) {
                    count++;
                }
                need[c1 - 'a']++;
            }
        }
        return false;
    }

    /**
     * 思路：
     * 滑动窗口 map实现
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int valid = 0;
        int left = 0, right = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                //  s1= "ab", s2 = "eidbaooo"
                if (right - left == s1.length()) {
                    return true;
                }

                char c1 = s2.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }

        }
        return false;
    }



    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion2(s1, s2));
    }
}
