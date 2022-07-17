package zuo.base.class01;

/**
 * Code07_EvenTimesOddTimes
 * 异或运算的应用
 * 异或：相同为0，不同为1
 * 0^N=N ;  N^N=0
 * <p>
 * 取反： ~N
 * 与： &N
 * <p>
 * 对于内存地址不一样的交换，可以使用异或运算：
 * a = a^b;  // 运行后 a=a^b  b=b
 * b = a^b； // 运行后 a=a^b  b=a^b^b=a
 * a = a^b;  // 运行后 a=a^b^a=b  b=a， 完成交换
 *
 * @author xiaoliang
 * @date 2021/09/12 15:43
 **/
public class Code07_EvenTimesOddTimes {
    /**
     * 数组中有若干个数出现偶数次，只有一个数出现奇数次，求该奇数
     *
     * @param arr
     * @return
     */
    public static int printOddTimesNum(int[] arr) {
        int eor = 0;
        for (int item : arr) {
            eor ^= item;
        }
        return eor;
    }

    /**
     * 数组中有若干个数出现偶数次，只有两个数出现奇数次，
     * 求这两个奇数
     *
     * @param arr
     * @return
     */
    public static int[] printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int item : arr) {
            eor ^= item;
        }
        if (eor == 0) {
            // eor 肯定不为 0
            throw new RuntimeException("输入参数错误");
        }
        // 那么eor对应的二进制位至少有一位是1，找出最右边的1
        int rightone = eor & (~eor + 1);

        int onlyOne = 0;
        // 将原数组分成两类，一类是该位置（d）上是1的，另一类是该位置上为0的
        for (int item : arr) {
            if ((item & rightone) == 0) {
                onlyOne ^= item;
            }
        }
        return new int[]{onlyOne, eor ^ onlyOne};
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2};
        System.out.println(printOddTimesNum(arr));

        int[] arr2 = {1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        int[] res = printOddTimesNum2(arr2);
        for (int item : res) {
            System.out.print(item + " ");
        }

    }

}
