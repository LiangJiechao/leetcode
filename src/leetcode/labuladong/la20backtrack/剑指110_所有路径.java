package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaoliang
 * @date 2022/04/04 21:56
 **/
public class 剑指110_所有路径 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> track = new LinkedList<>();
        dfs(graph, 0, graph.length - 1, track);
        return res;
    }

    void dfs(int[][] graph, int row, int target, LinkedList<Integer> track) {
        track.add(row);

        if (row == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int item : graph[row]) {
            dfs(graph, item, target, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new 剑指110_所有路径().allPathsSourceTarget(graph));
    }
}
