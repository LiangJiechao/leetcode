package zuo.baseascension.class10;

/**
 * 求一个数是不是2或4的幂
 * 2: 1 2 4 8 16 ...
 * 4: 1 4 16 64 ...
 *
 * @author xiaoliang
 * @date 2021/09/22 09:56
 **/
public class Code02_Power_2_4 {

    public static boolean isPower2(int n) {
        if (n <= 0) {
            return false;
        }
        // 二进制上只有一个1
        int rightOne = n & (~n + 1);
        return n - rightOne == 0;
    }

    public static boolean isPower4(int n) {
        // 二进制上只有一个 1，且这个 1在1 3 5 7 9... 位置上
        int check = 0x55555555;// 0101 0101 0101

        return isPower2(n) && (n & check) != 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " -- " + isPower4(i));
        }
    }
}
