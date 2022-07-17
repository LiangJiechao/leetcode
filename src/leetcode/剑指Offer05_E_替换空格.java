package leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author xiaoliang
 * @date 2021/11/23 20:08
 **/
public class 剑指Offer05_E_替换空格 {

    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int spaceNum = 0;
        // 统计空格个数
        for (char c : arr) {
            if (c == ' ') {
                spaceNum++;
            }
        }

        char[] res = new char[arr.length + spaceNum * 2];

        for (int i = arr.length - 1, j = res.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            } else {
                res[j--] = arr[i];
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
