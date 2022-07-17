package zuo.middleascension.class12;

/** 打表法：输入参数和输出参数简单，且有规律时使用
 * 先后手吃草，一次只能吃4^n 即(1，4，16，64...)，谁吃完谁赢（博弈论）
 *
 * @author xiaoliang
 * @date 2021/09/25 08:21
 **/
public class Class03_吃草问题 {

    public static String winner1(int n) {
        if (n < 0) {
            throw new RuntimeException("参数错误！");
        }
        return process1(n);
    }

    private static String process1(int n) {
        //0  1  2  3  4
        //后 先 后 先 先
        if (n < 5) {
            if (n == 0 || n == 2) {
                return "后手";
            } else {
                return "先手";
            }
        }
        //base是先手吃的分
        int base = 1;
        while (base <= n) {
            //winner1母程序中的先手，是子程序里的后手，子程序里剩余的数是：n-base;
            if (process1(n - base).equals("后手")) {
                return "先手";
            } else {
                if (base > n / 4) {// 防溢出
                    break;
                }
                base *= 4;
            }
        }
        return "后手";
    }

    public static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            System.out.println(i + " -- " + winner1(i) + " -- " + winner2(i) + " -- "
                    + (winner1(i) == winner2(i)));
        }
    }
}
