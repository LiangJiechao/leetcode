package leetcode;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 所有元素乘积之和不会溢出 32 位整数
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * @author xiaoliang
 * @date 2021/12/19 18:08
 **/
public class 剑指Offer66_M_构建乘积数组 {

    /**
     * 整体思路，
     * 结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积。
     * 一轮循环构建左边的乘积并保存在结果集中，
     * 二轮循环构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
     *
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {

        int len = a.length;
        int[] res = new int[len];

        // 一轮循环构建左边的乘积并保存在结果集中，
        for (int i = 0, process = 1; i < len; i++) {
            res[i] = process;
            process *= a[i];
        }

        // 二轮循环构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
        for (int i = len - 1, process = 1; i >= 0; i--) {
            res[i] *= process;
            process *= a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        System.out.println(constructArr(arr));
    }
}
