package offer.ali20220314.a4;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    int tmp = traverse(arr, i, j, m, n);
                    res += tmp;
                }
            }
        }
        System.out.println(res);
    }

    private static int traverse(int[][] arr, int i, int j, int m, int n) {
        if (i < 0 || i > m || j < 0 || j > n) {
            return 0;
        }
        int res = 0;
        for (int w = i; w >= 0; w--) {
            if (arr[w][j] == 1) {
                res++;
                break;
            }
        }

        for (int s = i; s < m; s++) {
            if (arr[s][j] == 1) {
                res++;
                break;
            }
        }

        for (int a = j; a >= 0; a--) {
            if (arr[i][a] == 1) {
                res++;
                break;
            }
        }

        for (int d = j; d < n; d++) {
            if (arr[i][d] == 1) {
                res++;
                break;
            }
        }

        return res;
    }
}