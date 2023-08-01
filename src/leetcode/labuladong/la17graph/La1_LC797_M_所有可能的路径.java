package leetcode.labuladong.la17graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * @author xiaoliang
 * @date 2022/03/06 16:46
 **/
public class La1_LC797_M_所有可能的路径 {


    List<List<Integer>> res = new LinkedList<>();
    /**
     * @param graph 是一个邻接矩阵
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int node, LinkedList<Integer> path) {

        path.add(node);

        if (node == graph.length - 1) {
            // 找到终点了
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        // dfs，遍历其孩子
        for (int i : graph[node]) {
            traverse(graph, i, path);
        }
        path.removeLast();

    }
}
