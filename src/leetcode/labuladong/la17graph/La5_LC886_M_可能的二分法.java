package leetcode.labuladong.la17graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的 两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，
 * 表示不允许将编号为 ai 和  bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 *
 * @author xiaoliang
 * @date 2022/03/06 20:46
 **/
public class La5_LC886_M_可能的二分法 {

    boolean[] visited;
    boolean[] color;
    boolean ok;

    public boolean possibleBipartition(int n, int[][] dislikes) {

        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        ok = true;

        // 构造图
        List<Integer>[] graph = toLinkedGraph(n, dislikes);

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                traverse(graph, i);
            }
        }

        return ok;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (!ok) {
            return;
        }
        visited[i] = true;

        for (Integer item : graph[i]) {
            if (!visited[item]) {
                color[item] = !color[i];
                traverse(graph, item);
            } else {
                if (color[item] == color[i]) {
                    ok = false;
                }
            }
        }

    }

    private List<Integer>[] toLinkedGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            // 初始化
            graph[i] = new LinkedList<>();
        }

        for (int[] item : dislikes) {
            graph[item[0]].add(item[1]);
            graph[item[1]].add(item[0]);
        }

        return graph;

    }
}
