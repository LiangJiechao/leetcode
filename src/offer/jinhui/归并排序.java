package offer.jinhui;

import java.util.Arrays;

/**
 * @author xiaoliang
 * @date 2022/04/12 18:46
 **/
public class 归并排序 {

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {

        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);

    }

    private void merge(int[] nums, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }

        // 有一个用完了
        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= right) {
            help[index++] = nums[p2++];
        }

        // 复制回原数组
        for (int i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {23, 315, 8, 25, 28, 92, 1144, 513, 626};
        new 归并排序().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
