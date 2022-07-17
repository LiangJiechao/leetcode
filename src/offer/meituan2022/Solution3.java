package offer.meituan2022;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有 m 道菜，每道菜只有 1 份。有 n 个顾客，每个顾客都有想两份要点的菜。
 * 只有当顾客吃到全部自己想要的菜的时候，顾客才会满意。
 * 你的任务是，合理地接取顾客的订单要求，尽可能让更多的顾客满意，
 * 输出最多有多少顾客可以满意。
 * n <= 20, m <= 40。
 * 输入
 * 20
 * 3
 * 1 2
 * 3 4
 * 2 3
 * 输出
 * 2
 * @author xiaoliang
 * @date 2022/03/13 15:46
 **/
public class Solution3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            people[i][0] = a;
            people[i][1] = b;
        }

        int[] menu = new int[m + 1];
        Arrays.fill(menu, 1);

        dfs(0, 0, people, menu, n, m);

        System.out.println(res);
    }

    static int res = 0;

    private static void dfs(int startIndex, int count, int[][] people, int[] menu, int n, int m) {
        if (startIndex == n) {
            res = Math.max(res, count);
            return;
        }

        for (int i = startIndex; i < n; i++) {
            int first = people[i][0];
            int second = people[i][1];

            if (menu[first] == 1 && menu[second] == 1) {
                menu[first]--;
                menu[second]--;
                dfs(i + 1, count + 1, people, menu, n, m);
                menu[first]++;
                menu[second]++;
            } else {
                dfs(i + 1, count, people, menu, n, m);
            }

        }

    }

}
