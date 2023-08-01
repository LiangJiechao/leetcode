package leetcode.labuladong.la17graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 * @author xiaoliang
 * @date 2022/03/06 17:00
 **/
public class La2_LC207_M_课程表 {

    // 防⽌重复遍历同⼀个节点
    boolean[] visited;
    boolean[] path;
    boolean hasCycle = false;

    /**
     * 思路：先转为邻接表，再判断是否有环 List<Integer>[] graph;
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = toLinkedGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (path[i]) {
            hasCycle = true;
        }
        // 有环，或者访问过就不用访问该节点了
        if (visited[i] || hasCycle) {
            return;
        }
        visited[i] = true;
        path[i] = true;

        for (Integer child : graph[i]) {
            traverse(graph, child);
        }
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
