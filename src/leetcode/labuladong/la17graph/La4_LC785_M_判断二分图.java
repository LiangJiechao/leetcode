package leetcode.labuladong.la17graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，
 * 并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 * <p>
 * 如果图是二分图，返回 true ；否则，返回 false 。
 * <p>
 * 输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * 输出：false
 * 解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
 * <p>
 * 输入：graph = [[1,3],[0,2],[1,3],[0,2]]
 * 输出：true
 * 解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。
 *
 * @author xiaoliang
 * @date 2022/03/06 20:20
 **/
public class La4_LC785_M_判断二分图 {

    boolean[] visited;
    boolean[] color;
    boolean ok;

    /**
     * 思路：就是相邻节点之间的颜色要不一样
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        ok = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i);
            }
        }

        return ok;
    }

    private void dfs(int[][] graph, int i) {
        if (!ok) {
            return;
        }

        visited[i] = true;

        for (int item : graph[i]) {
            if (!visited[item]) {
                // 那么应该给节点 item 涂上和节点 i 不同的颜⾊
                color[item] = !color[i];
                dfs(graph, item);
            } else {
                if (color[item] == color[i]) {
                    ok = false;
                }
            }

        }

    }

    private void bfs(int[][] graph, int i) {
        Queue<Integer> queue = new LinkedList<>();

        visited[i] = true;
        queue.offer(i);

        while (!queue.isEmpty() && ok) {
            Integer poll = queue.poll();
            for (int item : graph[poll]) {
                if (!visited[item]) {
                    color[item] = !color[poll];
                    visited[item] = true;
                    queue.offer(item);
                } else {
                    if (color[item] == color[poll]) {
                        ok = false;
                        break;
                    }
                }
            }
        }

    }

}
