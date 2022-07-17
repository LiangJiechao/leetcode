package leetcode;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * @author xiaoliang
 * @date 2021/10/25 17:41
 **/
public class LC46_M_全排列 {

    public static List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        List<List<Integer>> res = new LinkedList<>();

        process(nums, 0, res);

        return res;
    }

    private static void process(int[] nums, int index, List<List<Integer>> res) {

        if (index == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int item : nums) {
                list.add(item);
            }
            res.add(list);
        }

        for (int j = index; j < nums.length; j++) {
            swap(nums, index, j);
            process(nums, index + 1, res);
            swap(nums, index, j);
        }
    }


    public static List<List<Integer>> permute2(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        List<List<Integer>> res = new LinkedList<>();

        process2(nums, 0, res);

        return res;
    }
    private static void process2(int[] nums, int index, List<List<Integer>> res) {

        if (index == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int item : nums) {
                list.add(item);
            }
            res.add(list);
        }

        // 如果数字有可能相同
        Set<Integer> set = new HashSet<>();

        for (int j = index; j < nums.length; j++) {
            if (set.add(nums[j])){
                swap(nums, index, j);
                process2(nums, index + 1, res);
                swap(nums, index, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,3,4};
        List<List<Integer>> permute2 = permute2(arr);
        for (List<Integer> list : permute2) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println(permute2.size());
    }

}
