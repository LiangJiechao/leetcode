package leetcode.labuladong.la10parentheses;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），
 * 以使得到的括号字符串有效。
 * 只包含 '(' 和 ')' 字符。
 *
 * @author xiaoliang
 * @date 2022/02/25 14:43
 **/
public class La2_LC921_M_使括号有效的最小添加 {

    public int minAddToMakeValid(String s) {
        int res = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                left--;
            }
            if (left == -1) {
                left = 0;
                res++;
            }

        }

        return res + left;
    }

}
