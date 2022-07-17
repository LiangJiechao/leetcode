package leetcode;

/**
 * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 * @author xiaoliang
 * @date 2021/10/20 10:36
 **/
public class LC167_E_两数之和_输入有序数组 {

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j;) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }

    /**
     * 思路：暴力搜索
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new RuntimeException("参数错误");
        }
        int[] result = new int[2];
        for (int i = 0; i < numbers.length && target >= numbers[i]; i++) {
            result[0] = i + 1;
            int temp = target - numbers[i];
            for (int j = i + 1; j < numbers.length && temp >= numbers[j]; j++) {
                if (temp == numbers[j]) {
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 4};
        int target = 0;
        for (int item : twoSum2(arr, target)) {
            System.out.println(item);
        }
    }

}
