package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author xiaoliang
 * @date 2022/03/09 16:35
 **/
public class La5_LC77_M_组合 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(1, n, k, path);
        return res;
    }

    private void backtrack(int startIndex, int n, int k, LinkedList<Integer> path) {

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++) {

            path.add(i);
            backtrack(i + 1, n, k, path);
            path.removeLast();
        }

    }
}
