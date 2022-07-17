package offer.meituan2022319.m1;

import java.util.Scanner;

/**
 * 第一行有一个正整数n(1<=n<=5000)，代表小美有n种备选商品。 第二行有n个正整数，第 i 个数代表第 i 种备选商品的原价。商品的原价不会超过500。 第三行有n个正整数，第 i 个数代表第 i
 * 种备选商品的折扣价，折扣价不会高于商品的原价。 第四行有一个正整数m(1<=n<=5000)，代表满减规则的数量。 第五行有m个正整数，第 i 个代表第 i 条满减规则中的参数c(1<=c<=1000000)。 第六行有m个正整数，第
 * i 个代表第 i 条满减规则中的参数d(1<=d<=c)。
 *
 * 满减规则中的参数c按从小到大排列。
 *
 * 3 5 10 8 5 8 7 2 15 22 1 4
 *
 * 数字间两两有空格隔开。
 * 
 * @author xiaoliang
 * @date 2022/03/19 10:03
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] yuanjiaArr = new int[n];
        for (int i = 0; i < n; i++) {
            yuanjiaArr[i] = scanner.nextInt();
        }
        int[] discountArr = new int[n];
        for (int i = 0; i < n; i++) {
            discountArr[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] man = new int[m];
        for (int i = 0; i < m; i++) {
            man[i] = scanner.nextInt();
        }
        int[] manjian = new int[m];
        for (int i = 0; i < m; i++) {
            manjian[i] = scanner.nextInt();
        }

        char[] res = new char[n];
        int sumYuan = 0;
        int sumZhe = 0;
        // 仅购买前 i 种备
        for (int i = 0; i < n; i++) {
            sumYuan += yuanjiaArr[i];
            sumZhe += discountArr[i];

//            int first = zhekou(i + 1, yuanjiaArr, discountArr);
            int first = sumZhe;
            // int second = manjianjia(i+1,m,yuanjiaArr,man,manjian);
            int second = manjianjia(i, sumYuan, m, man, manjian);

            if (first == second) {
                res[i] = 'B';
            } else if (first > second) {
                res[i] = 'M';
            } else if (second > first) {
                res[i] = 'Z';
            }
        }
        System.out.println(res);
    }

    private static int manjianjia(int i, int sumYuan, int m, int[] man, int[] manjian) {
        if (i < m) {

        } else {
            int jianduoshao = 0;
            for (int j = 0; j < man.length; j++) {
                if (sumYuan >= man[j]) {
                    if (jianduoshao < manjian[j]) {
                        jianduoshao = manjian[j];
                    }
                } else {
                    break;
                }
            }
            sumYuan -= jianduoshao;
        }
        return sumYuan;
    }

    private static int manjianjia(int i, int m, int[] yuanjia, int[] man, int[] manjian) {
        int sum = 0;
        if (i < m) {
            for (int j = 0; j < i; j++) {
                sum += yuanjia[j];
            }
        } else {
            for (int j = 0; j < i; j++) {
                sum += yuanjia[j];
            }
            int index = 0;
            for (int j = 0; j < man.length; j++) {
                if (sum >= man[j]) {
                    index = j;
                } else {
                    break;
                }
            }
            sum -= manjian[index];
        }
        return sum;
    }

    private static int zhekou(int i, int[] yuanjia, int[] discountArr) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += discountArr[j];
        }
        return sum;
    }
}
