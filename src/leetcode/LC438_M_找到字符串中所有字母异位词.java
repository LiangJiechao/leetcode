package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * <p>
 * s 和 p 仅包含小写字母
 *
 * @author xiaoliang
 * @date 2022/01/06 09:38
 **/
public class LC438_M_找到字符串中所有字母异位词 {

    /**
     * 思路：滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return new ArrayList<>();
        }
        // s 和 p 仅包含小写字母
        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need[c - 'a'] > 0) {
                count--;
            }
            need[c - 'a']--;

            while (count == 0) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                if (need[c1 - 'a'] == 0) {
                    count++;
                }
                need[c1 - 'a']++;
                left++;
            }

        }
        return res;
    }
}
