package offer.weizhongbank.w20220411.wei4;

/**
 * @author xiaoliang
 * @date 2022/04/21 10:28
 **/
public class 最少冲多少钱能赢游戏 {

    public static int leastMoney(int[] arr1, int[] arr2, int n) {

        int len = arr1.length;
        int[] leastMoney = new int[len];

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < len; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];

            if (sum1 < sum2) {
                leastMoney[i] = (sum2 - sum1) / (i + 1) + 1;
            }
        }

        return leastMoney[n - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 4, 2};
        // int[] res = {2, 2, 1};
        leastMoney(arr1, arr2, 2);
    }

}
