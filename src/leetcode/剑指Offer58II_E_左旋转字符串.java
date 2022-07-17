package leetcode;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * @author xiaoliang
 * @date 2021/11/23 21:12
 **/
public class 剑指Offer58II_E_左旋转字符串 {

    /**
     * 思路：0-(n-1)逆转，n-(s.length-1)逆转，0-(s.length-1)逆转
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords2(String s, int n) {
        int R = s.length() - 1;
        char[] arr = s.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, R);
        reverse(arr, 0, R);
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int i, int j) {
        char temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 思路：申请额外空间，依次复制字符
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {

        if (s == null || s.length() <= 1 || n > s.length()) {
            return s;
        }
        char[] arr = s.toCharArray();
        char[] res = new char[arr.length];
        int i = 0;
        while (n < arr.length) {
            res[i++] = arr[n++];
        }
        int j = 0;
        while (i < res.length) {
            res[i++] = arr[j++];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int k = 6;
        System.out.println(reverseLeftWords2(s, k));
    }

}
