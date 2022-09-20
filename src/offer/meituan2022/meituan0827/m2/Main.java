package offer.meituan2022.meituan0827.m2;

import java.util.Scanner;

/**
 * 
 * @author xiaoliang
 * @date 2022/08/27 15:54
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean[] flag = new boolean[n+1];

        for (int i = m-1; i >=0 ; i--) {
            if (!flag[arr[i]]){
                System.out.print(arr[i] +" ");
                flag[arr[i]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i]){
                System.out.print(i +" ");
                flag[i] = true;
            }
        }

    }
}
