package leetcode.labuladong.la17graph;

import java.util.*;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 
 * times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *
 * @author xiaoliang
 * @date 2022/03/07 11:59
 **/
public class La7_LC743_M_网络延迟时间 {

    // times 记录边和权重，n 为节点个数（从 1 开始），k 为起点
    // 计算从 k 发出的信号⾄少需要多久传遍整幅图
    public int networkDelayTime(int[][] times, int n, int k) {

        // 节点编号是从 1 开始的，所以要⼀个⼤⼩为 n + 1 的邻接表
        List<int[]>[] graph = buildLinkedGraph(times, n);
        // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
        int[] distTo = dijkstra(k, graph);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                res = -1;
                break;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State {
        // 图节点的id
        int id;
        // 从start节点到当前节点的局办理
        int disFromStart;

        public State(int id, int disFromStart) {
            this.id = id;
            this.disFromStart = disFromStart;
        }
    }

    private int[] dijkstra(int start, List<int[]>[] graph) {
        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;

        // 优先级队列，distFromStart 较小的排在前面，这样可以减少很多操作
        Queue<State> queue = new PriorityQueue<>((o1, o2) -> o1.disFromStart - o2.disFromStart);
//        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(start, distTo[start]));

        while (!queue.isEmpty()) {
            State curState = queue.poll();
            int curNodeId = curState.id;
            int curDistFromStart = curState.disFromStart;

            // 优先级队列，distFromStart 较小的排在前面，这样可以减少很多操作
            if (curDistFromStart > distTo[curNodeId]) {
                continue;
            }

            for (int[] neighbor : graph[curNodeId]) {
                int nextNodeId = neighbor[0];
                int nextDistFromStart = distTo[curNodeId] + neighbor[1];

                // 不用visited也不会无限循环，因为加入队列是有条件的
                // 当前新路径比原来的路径短
                if (nextDistFromStart < distTo[nextNodeId]) {
                    distTo[nextNodeId] = nextDistFromStart;
                    queue.offer(new State(nextNodeId, nextDistFromStart));
                }
            }
        }
        return distTo;
    }

    private List<int[]>[] buildLinkedGraph(int[][] times, int n) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        // times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weigh = time[2];
            graph[from].add(new int[]{to, weigh});
        }
        return graph;

    }

}
