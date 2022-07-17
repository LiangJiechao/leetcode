package b;
/**
 * @description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * @author xiaoliang
 * @date 2021/7/3 15:07
 * @version 1.0
 */
public class MaxAreaWater {

    /**
     * @description:
     * 思路：
     * 前提：i < j
     * 假设 ai < aj，面积为 ai * (j - i)
     * 假设右板子移动到了新位置 k (i < k < j)，新面为 Min(ai, ak) * (k - i)
     * 因 Min(ai, ak) <= ai，且 (k-i) < (j - i)，易知新面积会小于之前的面积
     * 也就是说，当矮板子固定时，无论如何移动都不会得到更大的面积，所以需要丢弃矮板子
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;

        int result = 0;

        while (left<=right){
            result = Math.max(result,Math.min(height[left],height[right])*(right-left));
            if(height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxAreaWater obj = new MaxAreaWater();
        System.out.println(obj.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
