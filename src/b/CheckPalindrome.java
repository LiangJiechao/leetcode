package b;

/**
 * @description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * @author xiaoliang
 * @date 2021/6/25 10:39
 * @version 1.0
 */
public class CheckPalindrome {

    public static boolean isPalindrome(String s) {

        if (s==""){
            return true;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        int i =0,j=sb.length()-1;
        while (i < j) {

            if(Character.toLowerCase(sb.charAt(i))==Character.toLowerCase(sb.charAt(j))){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {

        if (s==""){
            return true;
        }

        int i =0,j=s.length()-1;
        while (i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }else{
                if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPalindrome.isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
