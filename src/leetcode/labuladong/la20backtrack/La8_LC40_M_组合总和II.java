package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * @author xiaoliang
 * @date 2022/03/09 17:20
 **/
public class La8_LC40_M_组合总和II {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);

        backtrack(candidates, 0, 0, target, path);
        return res;
    }

    private void backtrack(int[] nums, int startIndex, int trackSum, int target, LinkedList<Integer> path) {

        if (trackSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // base case，超过目标和，直接结束，剪枝
        if (trackSum > target) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {

            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            trackSum += nums[i];

            backtrack(nums, i + 1, trackSum, target, path);

            path.removeLast();
            trackSum -= nums[i];
        }

    }

}
