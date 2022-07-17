package leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author xiaoliang
 * @date 2021/11/02 14:46
 **/
public class LC67_E_二进制求和 {

    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0 || carry > 0) {
            int temp = carry;
            temp += i1 >= 0 ? arr1[i1--] - '0' : 0;
            temp += i2 >= 0 ? arr2[i2--] - '0' : 0;
            sb.insert(0, temp % 2);
            carry = temp / 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(3 % 2);
        System.out.println(2 % 2);
        System.out.println(1 % 2);
        System.out.println(3 / 2);
    }

}
