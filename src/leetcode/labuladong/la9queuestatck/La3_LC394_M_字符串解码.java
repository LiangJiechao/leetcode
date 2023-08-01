package leetcode.labuladong.la9queuestatck;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * @author xiaoliang
 * @date 2022/09/21 14:58
 **/
public class La3_LC394_M_字符串解码 {

    /**
     * 思路：两个栈，数字栈 和 字母栈
     * 如果遍历到数字，数字入栈
     * 如果遍历到字母和 [，入栈
     * 如果遍历到 ] ，把 [ ]中的字母 出栈，并 * 数字，重新入栈
     * @param s
     * @return
     */
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> charStack = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= '1' && c <= '9') {
                // getNum()
                int num = 0;
                while (arr[i] >= '0' && arr[i] <= '9') {
                    num = num * 10 + arr[i] - '0';
                    i++;
                }
                i--;
                numStack.push(num);
                continue;
            }
            if (arr[i] == ']') {
                List<String> list = new LinkedList<>();
                while (true) {
                    String pop = charStack.pop();
                    if (pop.equals("[")) {
                        break;
                    }
                    list.add(0, pop);
                }
                Integer time = numStack.pop();
                StringBuilder sb = new StringBuilder();
                for (String s1 : list) {
                    sb.append(s1);
                }

                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    sb2.append(sb);
                }
                charStack.push(sb2.toString());
                continue;
            }
            // 如果是字母
            charStack.push(String.valueOf(arr[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        System.out.println(new La3_LC394_M_字符串解码().decodeString(s));
    }

}
