package b;

/**
 * @description:
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * @author xiaoliang
 * @date 2021/6/27 21:01
 * @version 1.0
 */
public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int i=0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x){

        if(x<0){
            return false;
        }
        //逆序数
        int reverseNum=0;
        int cur=x;
        while (cur!=0){
            reverseNum = 10*reverseNum+cur%10;
            cur/=10;
        }
        return reverseNum==x;
    }

}
