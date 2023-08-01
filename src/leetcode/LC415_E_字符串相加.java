package leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 *
 * @author xiaoliang
 * @date 2021/11/02 12:01
 **/
public class LC415_E_字符串相加 {

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        StringBuilder result = new StringBuilder();
        int carry = 0;
        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;

        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            int temp = carry;
            temp += index1 >= 0 ? arr1[index1--] - '0' : 0;
            temp += index2 >= 0 ? arr2[index2--] - '0' : 0;
            result.insert(0, temp % 10);
            carry = temp / 10;

        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

}
