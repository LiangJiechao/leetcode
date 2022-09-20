package offer.meituan2022.meituan0827.m5;

import java.util.Scanner;

/**
 * 样例输入
 * 6 2 100
 * 1 50
 * 0 1 2 0 1 0
 * 样例输出
 * 102
 *
 * @author xiaoliang
 * @date 2022/08/27 17:02
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int T = scanner.nextInt();
        int[] wanju = new int[k];
        for (int i = 0; i < k; i++) {
            wanju[i] = scanner.nextInt();
        }
        int[] event = new int[n];
        for (int i = 0; i < n; i++) {
            event[i] = scanner.nextInt();
        }

        int[] wanjuNum = new int[k];
        int wanjuSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (event[i] == 0) {
                // 遇到猫
                if (wanjuSum == 0) {
                    res += T;
                } else {
                    int index = getLessWanjuIndex(wanju, wanjuNum);
                    int needTime = wanju[index];
                    if (needTime <= T) {
                        wanjuSum--;
                        wanjuNum[index]--;
                        res += needTime;
                    }else {
                        res += T;
                    }
                }

            } else {
                // 遇到玩具
                wanjuNum[event[i] - 1]++;
                wanjuSum++;
            }

        }

        System.out.println(res);
    }

    private static int getLessWanjuIndex(int[] wanju, int[] wanjuNum) {
        int len = wanju.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            if (wanjuNum[i]>0){
                if (min > wanju[i] ){
                    // 更新最小值
                    min = wanju[i];
                    minIndex = i;
                }
            }

        }
        return minIndex;
    }
}
