package b;

import java.util.HashSet;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * @date 2021/6/25 10:24
 */
public class LongestPalindrome {

    /**
     * @description:
     * 统计字符出现的次数即可，双数才能构成回文。因为允许中间一个数单独出现，比如“abcba”，
     * 所以如果最后有字母落单，总长度可以加 1。
     * 首先将字符串转变为字符数组。然后遍历该数组，
     * 判断对应字符是否在hashset中，如果不在就加进去，如果在就让count++，然后移除该字符！
     * 这样就能找到出现次数为双数的字符个数。
     * @param:
     * @return:
     *
     * @author xiaoliang
     * @date: 2021/6/25 10:36
     */
    public static int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                set.remove(ch);
                count++;
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindrome.longestPalindrome("abccccdd"));
    }
}
