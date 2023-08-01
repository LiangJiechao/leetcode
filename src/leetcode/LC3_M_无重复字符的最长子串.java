package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] window = new int[128];

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
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
     * 思路：dp问题：看到子串子序列问题，想以i为结尾怎么怎么样
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring3(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();

        // i位置上的字符上次出现的位置
        int[] map = new int[128];
        Arrays.fill(map, -1);
//        for (int i = 0; i < 128; i++) {
//            map[i] = -1;
//        }
        int[] dp = new int[arr.length];
        int max = 0;
        int pre = -1; // i-1为结尾的最长无重复子串长度

        for (int i = 0; i < arr.length; i++) {
            pre = Math.max(pre, map[arr[i]]);
            dp[i] = i - pre;
            max = Math.max(max, dp[i]);
            map[arr[i]] = i;
        }

        return max;
    }

    /**
     * 利用set来实现类似与滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3_M_无重复字符的最长子串 obj = new LC3_M_无重复字符的最长子串();
        String s = "aaaaaaaaaaaab";
        System.out.println(obj.lengthOfLongestSubstring(s));
        System.out.println(obj.lengthOfLongestSubstring2(s));
        System.out.println(obj.lengthOfLongestSubstring3(s));
    }
}
