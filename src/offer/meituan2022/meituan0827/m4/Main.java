package offer.meituan2022.meituan0827.m4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 3 5
 * 1 2 3
 * 7 5 3
 * 样例输出
 * 10
 *
 * @author xiaoliang
 * @date 2022/08/27 16:49
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();

        int[] power = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }

        if (b < power[0]) {
            System.out.println(-1);
            return;
        }
        if (b == power[0]) {
            System.out.println(n * time[0]);
            return;
        }

        // 先找可以使用那些机器人
        List<List<Integer>> jiqiren = new LinkedList<>();
        // 剩余的电量
        int rest = b - power[0];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(power, 1, rest, jiqiren, path);

//        System.out.println(jiqiren);

        int res = Integer.MAX_VALUE;

        for (List<Integer> list : jiqiren) {
            int tmp = getCostTime(list, time, n);
            res = Math.min(res, tmp);
        }

        System.out.println(res);

    }

    private static int getCostTime(List<Integer> list, int[] time, int n) {

        if (list.size() == 0) {
            return n * time[0];
        }
        int res = Integer.MIN_VALUE;

        int pre = 0;
        for (Integer item : list) {
            int sum = (item - pre) * time[pre];
            pre = item;
            res = Math.max(sum, res);
        }
        res = Math.max((n - pre) * time[pre], res);
        return res;
    }

    private static void dfs(int[] power, int startIndex, int rest, List<List<Integer>> jiqiren, LinkedList<Integer> path) {
        jiqiren.add(new LinkedList<>(path));

        if (startIndex >= power.length) {
            return;
        }

        for (int i = startIndex; i < power.length; i++) {
            if (rest < power[i]) {
                continue;
            }

            rest -= power[i];
            path.add(i);

            dfs(power, i + 1, rest, jiqiren, path);

            path.removeLast();
            rest += power[i];

        }

    }
}
