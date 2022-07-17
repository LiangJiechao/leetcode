package leetcode;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * @author xiaoliang
 * @date 2021/11/07 16:04
 **/
public class LC912_M_排序数组快排 {

    public int[] sortArray(int[] nums) {
        quickSort(nums);
        return nums;
    }

    private void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int L, int R) {
        if (L < R) {
            swap(nums, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(nums,L,R);
            quickSort(nums,L,p[0]);
            quickSort(nums,p[1],R);
        }
    }

    private int[] partition(int[] nums, int L, int R) {
        int pivot = nums[R];
        // less 表示小区，一开始小区和大区一个也没括上
        int less = L-1;
        // more 表示大区
        int more = R+1;

        while (L<=R){
            if (nums[L]<pivot){
                swap(nums,++less,L++);
            }else if (nums[L]>pivot){
                swap(nums,L,R--);
                more--;
            }else {
                // nums[L] == pivot
                L++;
            }
        }
        return new int[]{less,more};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
