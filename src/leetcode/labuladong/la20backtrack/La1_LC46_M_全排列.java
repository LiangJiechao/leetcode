package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
public class La1_LC46_M_全排列 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(nums, used, path);

        return res;
    }

    private void backtrack(int[] nums, boolean[] used, LinkedList<Integer> path) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }
            // 剪枝逻辑，固定相同的元素在排列中的相对位置
            // 比如说nums = [1,2,2']这个例子，我保持排列中2一直在2'前面。
            // 如果 前面的 相邻相等元素没有用过，则跳过；这样就能保持住相对次序
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            backtrack(nums, used, path);

            path.removeLast();
            used[i] = false;
        }

    }

}
