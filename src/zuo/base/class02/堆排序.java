package zuo.base.class02;

import java.util.Arrays;

/**
 * @author xiaoliang
 * @date 2022/04/01 17:14
 **/
public class 堆排序 {

    public void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }

        int heapSize = nums.length;
        // 堆化后，可以输出排序
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }

    }

    private void heapify(int[] nums, int index, int heapSize) {

        int left = 2 * index + 1;
        while (left < heapSize) {
            // 小根堆
            int largeChild = (left + 1 < heapSize && nums[left] < nums[left + 1]) ? left + 1 : left;
            if (nums[largeChild] >= nums[index]) {
                swap(nums, largeChild, index);
                index = largeChild;
                left = 2 * index + 1;
            } else {
                return;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 13214, 2314, 341, 53, 341, 321432, 3214, 31, 53, 15, 123, 123};
        new 堆排序().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
