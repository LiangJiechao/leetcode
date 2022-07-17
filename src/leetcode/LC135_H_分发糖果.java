package leetcode;

import java.util.Arrays;

/**
 * @author xiaoliang
 * @date 2022/04/15 09:51
 **/
public class LC135_H_分发糖果 {

    //[1,2,87,87,87,2,1]
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        //初始化
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        //从左往右
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        //从右往左
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        new LC135_H_分发糖果().candy(arr);
    }
}
