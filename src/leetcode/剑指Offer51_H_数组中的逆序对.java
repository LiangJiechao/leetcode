package leetcode;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * @author xiaoliang
 * @date 2022/04/21 11:35
 **/
public class 剑指Offer51_H_数组中的逆序对 {

    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left <= right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        int l = mergeSort(nums, left, mid);
        int r = mergeSort(nums, mid + 1, right);
        return l + r + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int index = 0;

        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += nums[p1] > nums[p2] ? mid - p1 + 1 : 0;
            help[index++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }

        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= right) {
            help[index++] = nums[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
        return res;
    }

    // 暴力法，O(n2)，超时了
    public int reversePairs2(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }

        }
        return count;
    }
}
