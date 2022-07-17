package leetcode.labuladong.la23dp;

/**
 * @author xiaoliang
 * @date 2022/04/16 15:37
 **/
public class LC647_M_回文子串的个数 {

    // 中心扩展法
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            res += countSubstrings(s, i, i);
            res += countSubstrings(s, i, i + 1);
        }
        return res;
    }

    public int countSubstrings(String s, int start, int end) {
        int count = 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }
}
