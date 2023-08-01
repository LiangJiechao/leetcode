package leetcode.labuladong.la4binarysearch;

import java.util.Arrays;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 * @author xiaoliang
 * @date 2022/02/24 16:56
 **/
public class La3_875_爱吃香蕉的珂珂 {

    /**
     * 思路：最小left=1 ， 最大 香蕉堆的最大值right
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int mostLeft = -1;
        // 二分查找最慢且符合的速度。
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(piles, mid, h)) {
                mostLeft = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mostLeft;
    }

    private boolean check(int[] piles, int speed, int h) {
        int sum = 0;
        for (int pile : piles) {
            sum += getHour(pile, speed);
        }
        return sum <= h;
    }

    private int getHour(int pile, int speed) {
        // return pile%speed==0?pile/speed:pile/speed+1;
        return (int) Math.ceil(1.0 * pile / speed);
    }

    public static void main(String[] args) {
        La3_875_爱吃香蕉的珂珂 obj = new La3_875_爱吃香蕉的珂珂();
        /*piles = [30,11,23,4,20], H = 5*/
        int[] piles = {30,11,23,4,20};
        int H = 6;
        System.out.println(obj.minEatingSpeed(piles, H));
    }
}
