package leetcode;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * @author xiaoliang
 * @date 2021/11/04 17:28
 **/
public class LC88_E_合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
//        if (m == 0) {
//            n-=1;
//            while (n>=0){
//                nums1[n] = nums2[n];
//                n--;
//            }
//            return;
//        }

        int i1 = m - 1;
        int i2 = n - 1;

        int index = nums1.length - 1;

        while (index >= 0 && i2 >= 0 && i1 >= 0) {
            if (nums2[i2] > nums1[i1]) {
                nums1[index] = nums2[i2--];
            } else {
                nums1[index] = nums1[i1--];
            }
            index--;
        }
        // i1 或 i2 == -1
        while (index >= 0) {
            if (i2 == -1) {
                return;
            } else {
                nums1[index--] = nums2[i2--];
            }
        }

        System.out.println(nums1);

    }

    public static void main(String[] args) {
        int[] num1 = {0};
        int[] num2 = {1};
        merge(num1, 0, num2, 1);
    }

}
