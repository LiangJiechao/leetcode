package b;

/**
 * @description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * @author xiaoliang
 * @date 2021/7/1 16:08
 * @version 1.0
 */
public class LongestPalindromeSubString {

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //方法1：暴解
    public String longestPalindrome(String s) {
        String ans = "";
        int max= 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                // s.substring  "smiles".substring(1, 5) returns "mile"
                String test= s.substring(i,j);
                if (isPalindrome(test)&&test.length()>max){
                    ans = test;
                    max = test.length();
                }
            }
        }
        return ans;
    }




    public static void main(String[] args) {
        LongestPalindromeSubString obj = new LongestPalindromeSubString();
        System.out.println(obj.longestPalindrome("babad"));
    }
}
