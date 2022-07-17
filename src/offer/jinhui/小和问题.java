package offer.jinhui;

import java.util.Scanner;

/**
 * @author xiaoliang
 * @date 2022/04/12 19:37
 **/
public class 小和问题 {

    public long smallSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return smallSum(nums, 0, nums.length - 1);
    }

    private long smallSum(int[] nums, int left, int right) {

        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return smallSum(nums, left, mid)
                + smallSum(nums, mid + 1, right)
                + merge(nums, left, mid, right);
    }

    private long merge(int[] nums, int left, int mid, int right) {

        int[] help = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        long smallSum = 0;
        while (p1 <= mid && p2 <= right) {
            smallSum += nums[p1] <= nums[p2] ? nums[p1] * (right - p2 + 1) : 0;
            help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
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
        return smallSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(new 小和问题().smallSum(nums));
    }
}
