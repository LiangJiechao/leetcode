package leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * @author xiaoliang
 * @date 2021/10/21 17:05
 **/
public class LC344_E_反转字符串 {

    /**
     * 双指针法，两个相互交换
     * @param arr
     */
    public static void reverseString(char[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(char[] arr, int L, int R) {
        char temp;
        while (L < R) {
            temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
            L++;
            R--;
        }
    }

    public static void main(String[] args) {
        char[] arr = "hello".toCharArray();
        reverseString(arr);
        System.out.println(arr);
    }
}
