package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 *
 * @author xiaoliang
 * @date 2021/11/02 14:55
 **/
public class LC989_E_数组形式的整数加法 {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        num[i] += k;
        int carry = 0;
        while (i >= 0 || carry > 0) {
            int temp = carry;
            temp += i >= 0 ? num[i--] : 0;
            list.add(0, temp % 10);
            carry = temp / 10;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        addToArrayForm(arr, k);
    }

}
