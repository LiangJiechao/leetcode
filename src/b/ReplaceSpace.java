package b;

/**
 * @description:
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * @author xiaoliang
 * @date 2021/6/26 17:16
 * @version 1.0
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
