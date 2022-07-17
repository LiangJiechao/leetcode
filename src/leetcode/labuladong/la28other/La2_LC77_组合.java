package leetcode.labuladong.la28other;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按任何顺序返回答案。
 *
 * 输⼊：n = 4, k = 2
 * 输出：
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * @author xiaoliang
 * @date 2022/03/18 10:29
 **/
public class La2_LC77_组合 {

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> combine(int n, int k){
        if (n<k){
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();

        backtrack(n,k,1,path);
        return res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> path) {
        if (path.size()==k){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {

            path.add(i);
            backtrack(n, k, i+1, path);
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        System.out.println(new La2_LC77_组合().combine(4, 2));
    }
}
