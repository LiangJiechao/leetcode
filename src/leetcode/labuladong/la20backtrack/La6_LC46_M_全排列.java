package leetcode.labuladong.la20backtrack;

import java.util.*;
import java.util.stream.Collectors;

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
public class La6_LC46_M_全排列 {



    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, path);
        return res;

    }

    /* 排列问题回溯算法框架： 元素可重的全排列*/
    void backtrack(int[] nums, boolean[] used, LinkedList<Integer> path) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 1 2 2
        for (int i = 0; i < nums.length; i++) {
            // 剪枝逻辑
            if (used[i]) {
                continue;
            }
            // 剪枝逻辑，固定相同的元素在排列中的相对位置
            // 比如说nums = [1,2,2']这个例子，我保持排列中2一直在2'前面。
            // 如果前面的相邻相等元素没有用过，则跳过；这样就能保持住相对次序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 做选择
            used[i] = true;
            path.addLast(nums[i]);

            backtrack(nums, used, path);
            // 取消选择
            path.removeLast();
            used[i] = false;
        }
    }

    public static List<List<Integer>> permute3(int[] nums) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("参数错误");
        }
        List<List<Integer>> res = new LinkedList<>();

        process3(nums, 0, res);

        return res;
    }

    private static void process3(int[] nums, int index, List<List<Integer>> res) {

        if (index == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int item : nums) {
                list.add(item);
            }
            res.add(list);
        }

        for (int j = index; j < nums.length; j++) {
            swap(nums, index, j);
            process3(nums, index + 1, res);
            swap(nums, index, j);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        process2(nums, 0, res);
        return res;
    }

    private static void process2(int[] nums, int index, List<List<Integer>> res) {

        if (index == nums.length) {
//            List<Integer> list = new LinkedList<>();
//            for (int item : nums) {
//                list.add(item);
//            }
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(collect);
        }

        // 如果数字有可能相同
        Set<Integer> set = new HashSet<>();

        for (int j = index; j < nums.length; j++) {
            if (set.add(nums[j])) {
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
        int[] nums = {1, 2, 2};
        System.out.println(new La6_LC46_M_全排列().permute(nums));
    }

}
