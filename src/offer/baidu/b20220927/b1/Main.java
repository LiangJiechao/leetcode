package offer.baidu.b20220927.b1;

import java.util.*;
import java.util.Scanner;

/**
 * 4 3
 * -1 2 -1 3
 *
 * @author xiaoliang
 * @date 2022/09/27 18:55
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        if (n == k) {
            System.out.println(sum);
            return;
        }
        // n > k
        long res = 0;
        for (int i = 0; i < k - 1; i++) {
            res += arr[i];
        }
        long tmp = 0;
        for (int i = k - 1; i < n; i++) {
            tmp += arr[i];
        }
        System.out.println(res + 1.0 * tmp / (n - k + 1));

    }
}

