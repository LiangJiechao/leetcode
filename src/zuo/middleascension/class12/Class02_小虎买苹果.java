package zuo.middleascension.class12;

/**
 * 打表法学习：
 * 小虎买苹果，有只能装6或8个的袋子，给定苹果数n，求最少要多少个袋子
 * 思路：先用8个的装，看剩下的能不能用6个的装，不能则减少一个8的袋子
 *
 * @author xiaoliang
 * @date 2021/09/24 11:05
 **/
public class Class02_小虎买苹果 {

    public static int minBags(int apple) {
        if (apple < 6) {
            return -1;
        }
        int bag8 = apple / 8;
        int rest = apple - bag8 * 8;
        int bag6 = -1;
        while (rest < GcdAndLcm.lcm(6, 8) && bag8 >= 0) {
            if (rest % 6 == 0) {
                bag6 = rest / 6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    // 观察到规律，打表法
    public static int minBagsAwesome(int apple) {

        if ((apple & 1) != 0) {
            // apple是奇数
            return -1;
        }
        if (apple < 18) {
            if (apple == 0) {
                return 0;
            } else if (apple == 6 || apple == 8) {
                return 1;
            } else if (apple == 12 || apple == 14 || apple == 16) {
                return 2;
            }
            return -1;
        }

        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 200; i++) {
            System.out.println(i + " -- " + (minBags(i) == minBagsAwesome(i)));
        }
    }
}
