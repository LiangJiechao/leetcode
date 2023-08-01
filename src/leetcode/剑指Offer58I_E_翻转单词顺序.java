package leetcode;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * <p>
 * 输入: "a good   example"
 * 输出: "example good a"
 *
 * @author xiaoliang
 * @date 2021/12/02 17:44
 **/
public class 剑指Offer58I_E_翻转单词顺序 {

    /**
     * 思路：先去除多余的空格（两端的去掉，中间的保留一个）
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        s = s.trim();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].equals(" ") || split[i].equals("")) {
                continue;
            }
            sb.append(split[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
