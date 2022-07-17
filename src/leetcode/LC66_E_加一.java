package leetcode;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 *
 * @author xiaoliang
 * @date 2021/11/02 12:21
 **/
public class LC66_E_加一 {

    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return digits;
        }
        int index = digits.length - 1;
        digits[index] += 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (index >= 0 || carry > 0) {
            int temp = carry;
            temp += index >= 0 ? digits[index--] : 0;
            sb.insert(0, temp % 10);
            carry = temp / 10;
        }
        char[] arr = sb.toString().toCharArray();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] - '0';
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        System.out.println(plusOne(digits));
    }

}
