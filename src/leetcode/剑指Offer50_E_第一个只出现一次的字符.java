package leetcode;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 输入：s = ""
 * 输出：' '
 *
 * @author xiaoliang
 * @date 2021/11/24 10:16
 **/
public class 剑指Offer50_E_第一个只出现一次的字符 {

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }

        int[] map = new int[26];

        char[] arr = s.toCharArray();
        for (char c : arr) {
            map[c - 'a']++;
        }
        for (char c : arr) {
            if (map[c - 'a'] == 1) {
                return c;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcodae"));
    }
}
