package leetcode.labuladong.la10parentheses;

/**
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * 请你返回让 s 平衡的最少插入次数。
 * <p>
 * 输入：s = "(()))"
 * 输出：1
 *
 * @author xiaoliang
 * @date 2022/02/25 14:49
 **/
public class La3_LC1541_M_平衡括号字符串的最少插入次数 {

    public int minInsertions(String s) {
        int res = 0;
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left += 2;
                // (()  ( === 因为())要连续，所以奇数时要加一个)
                if (left % 2 == 1) {
                    left -= 1;
                    res++;
                }
            }
            if (c == ')') {
                left--;
                // ) 一个)多出来时，在前面添加一个(
                if (left == -1) {
                    res++;
                    left = 1;
                }
            }
        }
        return res + left;
    }

}
