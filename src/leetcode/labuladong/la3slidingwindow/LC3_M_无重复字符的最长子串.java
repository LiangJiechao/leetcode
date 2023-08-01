package leetcode.labuladong.la3slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * @author xiaoliang
 * @date 2021/10/23 18:03
 **/
public class LC3_M_无重复字符的最长子串 {

    /**
     * 利用滑动窗口来实现 数组写法
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        /*
        * s = "pwwkew"
        * 3
        * */
        int[] window = new int[128];

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 不能用 c-'a'，因为int[128]足够表示了。
            // 如果只有小写英文字母的时候可以用 c-'a'，用int[26]表示
            window[c]++;

            while (window[c] > 1) {
                char c1 = s.charAt(left);
                window[c1]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * 利用滑动窗口来实现 map写法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                window.put(c1, window.get(c1) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }



    public static void main(String[] args) {
        LC3_M_无重复字符的最长子串 obj = new LC3_M_无重复字符的最长子串();
        String s = "aaaaaaaaaaaab";
        String s2 = "pwwkew";
        System.out.println(obj.lengthOfLongestSubstring2(s2));
        System.out.println((' ' - 'a'));
    }
}
