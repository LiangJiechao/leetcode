package offer.weizhongbank.w20220913.w1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 桌面上有n张卡片，每张卡片上都写有一个正整数，现在你可以从中选出三张卡片，将卡片上的三个数按任意顺序连接成一个新的数。例如，对于三个数字123、45、678，你可以将它们连成12345678、45123678、67845123、67812345或12367845等，可以证明67845123是能拼接出的最大的数。注意，对于卡片上的数字，你不能将其拆开。
 * <p>
 * 输入描述
 * 第一行是一个正整数n，表示有n张卡片。
 * <p>
 * 第二行是n个用空格隔开的正整数，其中第i个数a_i表示第i张卡片上写的数字。保证数字不含前导零。
 * <p>
 * 输出描述
 * 一行一个整数，表示能拼接出的最大的数。
 * <p>
 * 样例输入
 * 4
 * 123 45 678 23
 * 样例输出
 * 67845123
 *
 * @author xiaoliang
 * @date 2022/09/13 20:03
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        if (n < 3) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        int[] nums = new int[3];
        nums[0] = arr[0];
        nums[1] = arr[1];
        nums[2] = arr[2];
        LinkedList<String> path = new LinkedList<>();
        boolean[] used = new boolean[3];
        backtrace(nums, used, path);
        System.out.println(res);
    }

    private static void backtrace(int[] nums, boolean[] used, LinkedList<String> path) {
        if (path.size() == 3) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            BigDecimal tmp = new BigDecimal(sb.toString());
            BigDecimal now = new BigDecimal(res);
            if (now.compareTo(tmp) < 0) {
                res = sb.toString();
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(String.valueOf(nums[i]));
            backtrace(nums, used, path);
            used[i] = false;
            path.removeLast();
        }

    }

    static String res = "0";
}
