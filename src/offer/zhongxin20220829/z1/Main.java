package offer.zhongxin20220829.z1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xiaoliang
 * @date 2022/08/29 18:54
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int budge = scanner.nextInt();

        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            set.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (budge != 2 * arr[i] && set.contains(budge - arr[i])) {
                System.out.print(arr[i] + " " + (budge - arr[i]));
                return;
            }
        }

        System.out.print("Not Found");
    }

}
