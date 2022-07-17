package offer.tengxun.t3;

import java.util.Scanner;

/**
 * 给一堆字符串代表一排士兵，士兵编号1~n，字符串中‘0’的士兵代表进攻性的，‘1’的代表防御性的，
 * 每个士兵的攻击力或守备力为其下标值。
 * 将士兵分组，0~pos的是进攻组，只算攻击力，pos+1~n的是防御组，只算防御力。
 * pos可以取0~n。求攻击组的攻击力和防御组的防御力的差的绝对值的最小值。
 * <p>
 * 题目：士兵分组后进攻防守值最小差
 * 攻击力与防守力的绝对值的最小值
 * <p>
 * 或者用前缀和
 *
 * @author xiaoliang
 * @date 2022/04/24 19:56
 **/
public class Main {
    /**
     * 40%
     * 4
     * 0011
     * ==>1
     * 19
     * 1101010111100011011
     * ==>2
     */
    // Integer.MAX_VALUE==2147483647 21亿   2后有9个0
    // Long.MAX_VALUE==9223372036854775807  9后有18个0
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char[] arr = s.toCharArray();

        long attack = 0;
        long protect = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                attack += (i + 1);
            }
        }
        long res = attack;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                protect += (i + 1);
            } else {
                attack -= (i + 1);
            }
            res = Math.min(res, Math.abs(attack - protect));
        }
        System.out.println(res);
        System.out.println(preSum(n, s));
        System.out.println(niuke(n, s));
    }

    public static long preSum(int n, String str) {

        long[] attack = new long[n + 1];
        long[] protect = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            attack[i] = attack[i - 1];
            protect[i] = protect[i - 1];
            if (str.charAt(i - 1) == '0') {
                attack[i] += i;
            } else {
                protect[i] += i;
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, Math.abs(attack[i] - (protect[n] - protect[i])));
        }
        return res;
    }

    public static long niuke(int n, String str) {
        long attack[] = new long[n + 1];
        long defend[] = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            attack[i] = attack[i - 1];
            defend[i] = defend[i - 1];
            //只会进攻
            if (str.charAt(i - 1) == '0') {
                attack[i] += i;
            } else {
                //只会防守
                defend[i] += i;
            }
            //   System.out.println(i + "\t前缀和进攻值:" + attack[i]);
            //   System.out.println(i + "\t前缀和防御值:" + attack[i]);
        }
        //1-pos是进攻的 为1的 pos+1到n是防守
        //考虑全进攻和全防守的形式
        long ans = Math.min(attack[n], defend[n]);
        //     System.out.println("全进攻:" + attack[n]);
        //   System.out.println("全防守:" + defend[n]);
        for (int i = 1; i < n; i++) {
            //  System.out.println("坐标：\t" + i);
            //  System.out.println("\t\t进攻值:" + attack[i] + "\t防御值:" +(defend[n]-defend[i]));
            //  System.out.println("\t\t绝对值:" + Math.abs(attack[i] - (defend[n]-defend[i])));
            ans = Math.min(ans, Math.abs(attack[i] - (defend[n] - defend[i])));
        }
        return ans;
    }

}
