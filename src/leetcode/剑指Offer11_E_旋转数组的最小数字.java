package leetcode;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @author xiaoliang
 * @date 2021/11/24 10:22
 **/
public class 剑指Offer11_E_旋转数组的最小数字 {

    /**
     * 二分法
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {

        int L = 0;
        int R = numbers.length - 1;
        int mid;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[R] > numbers[mid]) {
                R = mid;
            } else if (numbers[R] < numbers[mid]) {
                L = mid + 1;
            } else {
                //去重
                R--;
            }
        }
        return numbers[L];
    }

    public int minArray2(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }

}
