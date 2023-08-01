package leetcode.labuladong.la17graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
 * 如果不可能完成所有课程，返回 一个空数组 。
 *
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * 记住拓扑排序就是后序遍历反转之后的结果，且拓扑排序只能针对有向⽆环图，进⾏拓扑排序之前要进⾏环检测，
 * @author xiaoliang
 * @date 2022/03/06 19:10
 **/
public class La3_LC210_M_课程表II {

    // 记住拓扑排序就是后序遍历反转之后的结果，且拓扑排序只能针对有向⽆环图，进⾏拓扑排序之前要进⾏环检测，
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = toLinkedGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        postOrder = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }
        Collections.reverse(postOrder);
        int[] res = postOrder.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    // 防⽌重复遍历同⼀个节点
    boolean[] visited;
    boolean[] path;
    boolean hasCycle = false;
    List<Integer> postOrder;

    private void traverse(List<Integer>[] graph, int i) {
        if (path[i]) {
            hasCycle = true;
        }
        // 有环，或者访问过就不用访问该节点了
        if (visited[i] || hasCycle) {
            return;
        }

        // 前序遍历位置
        visited[i] = true;
        path[i] = true;

        for (Integer child : graph[i]) {
            traverse(graph, child);
        }
        // 后序遍历位置
        postOrder.add(i);
        path[i] = false;
    }

    private List<Integer>[] toLinkedGraph(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] item : prerequisites) {
            int from = item[1];
            int to = item[0];
            // 修完课程 from 才能修课程 to
            graph[from].add(to);
        }
        return graph;
    }
}
