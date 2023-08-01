package offer.baidu.b20220927.b2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * input
 * 2
 * 5
 * 1 2 3 4 5
 * output
 * 5
 * 3
 *
 * @author xiaoliang
 * @date 2022/09/27 18:55
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        for (int i = 0; i < time; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
                map.put(arr[j],j);
            }
            res = 0;
            int[] presum = new int[n+1];
            for (int j = 1; j <= n; j++) {
                presum[j] = presum[j-1] + arr[j-1];
            }

            for (int j = 0; j < n; j++) {
                for (int k = j+1; k <= n; k++) {
                    if(presum[k]-presum[j] == (k-j)*(k-j+1)/2){
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    static int res = 0;

    private static void backtrace(int[] arr, int startIndex, LinkedList<Integer> list, int sum) {
        if (check(list, sum)) {
            res++;
        }
        for (int i = startIndex; i < arr.length; i++) {
            list.add(arr[i]);
            sum += arr[i];
            backtrace(arr, i + 1, list, sum);
            list.removeLast();
            sum -= arr[i];
        }

    }

    private static boolean check(LinkedList<Integer> list, int sum) {
        int n = list.size();
        if (n == 0) {
            return false;
        }
        return (1 + n) * n / 2 == sum;
    }
}
