package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * @date 2021/6/29 9:42
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        //合并数组
        for (int i = 0; i < arr.length; i++) {
            if (index2 == nums2.length || (index1 < nums1.length && nums1[index1] <= nums2[index2])) {
                arr[i] = nums1[index1++];
            } else {
                arr[i] = nums2[index2++];
            }
        }
        if (arr.length > 0 && arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) * 1.0 / 2;
        } else {
            return arr[arr.length / 2];
        }

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;
        int[] newArr = new int[len1+len2];

        while (i!=len1 && j!=len2)
        {
            if(nums1[i]<=nums2[j]) {
                newArr[k++] = nums1[i++];
            } else {
                newArr[k++] = nums2[j++];
            }
        }

        while (i!=len1) {
            newArr[k++] = nums1[i++];
        }
        while (j!=len2) {
            newArr[k++] = nums2[j++];
        }

        return (newArr[newArr.length/2] + newArr[(newArr.length-1)/2])*0.5;

    }


    /**
     * @description:
     * 用 len 表示合并后数组的长度，如果是奇数，我们需要知道第 （len+1）/2 个数就可以了，如果遍历的话需要遍历 int(len/2 ) + 1 次。如果是偶数，我们需要知道第 len/2和 len/2+1 个数，也是需要遍历 len/2+1 次。所以遍历的话，奇数和偶数都是 len/2+1 次。
     * 返回中位数的话，奇数需要最后一次遍历的结果就可以了，偶数需要最后一次和上一次遍历的结果。所以我们用两个变量 left 和 right，right 保存当前循环的结果，在每次循环前将 right 的值赋给 left。这样在最后一次循环的时候，left 将得到 right 的值，也就是上一次循环的结果，接下来 right 更新为最后一次的结果。
     *
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     *
     * @author xiaoliang
     * @date: 2021/6/29 10:30
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int aLength = nums1.length;
        int bLength = nums2.length;

        int aStart = 0, bStart = 0;
        int len = aLength + bLength;
        int left = -1, right = -1;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < aLength && (bStart >= bLength || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if((len&1)==0){
            return (left+right)/2.0;
        }else {
            return right;
        }
    }

    public static void main(String[] args) {
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        obj.findMedianSortedArrays(new int[]{}, new int[]{});
    }
}
