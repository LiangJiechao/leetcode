package zuo.middleascension.class16;

import java.util.HashMap;
import java.util.Map;

/**
 * 求无重复子串的最大长度
 * 思路：看到子序列、子数组或子串问题，就想以i为结尾的情况下会怎么怎么样
 * <p>
 * 两个限制：① i位置的值前面出现的位置 ② i-1为结尾的最长无重复子串长度
 * dp[i] = min(①,②)
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author xiaoliang
 * @date 2021/10/09 21:16
 **/
public class Class09_求无重复子串的最大长度 {

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();

        // i位置上的字符上次出现的位置
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
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

    public static int lengthOfLongestSubstring2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0; // 左边界
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {// 前面出现过
                left = Math.max(left, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
