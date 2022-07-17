package leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * @author xiaoliang
 * @date 2022/02/17 11:23
 **/
public class LC42_H_接雨水 {

    /**
     * 先算出 i 左右的最高墙壁
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        int[] lmax = new int[size];
        int[] rmax = new int[size];
        lmax[0] = height[0];
        rmax[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        for (int i = size - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < size - 1; i++) {
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC42_H_接雨水 obj = new LC42_H_接雨水();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap(height));
    }

}
