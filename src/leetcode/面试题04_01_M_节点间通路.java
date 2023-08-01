package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *  示例1:
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边
 * @author xiaoliang
 * @date 2022/09/27 10:17
 **/
public class 面试题04_01_M_节点间通路 {


    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        boolean[] visit = new boolean[n];

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int poll = queue.poll();
                if(poll == target){
                    return true;
                }

                visit[poll] = true;
                for(int item : graph[poll]){
                    if(!visit[item]){
                        queue.offer(item);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        * 12
[ [0, 1], [1, 2], [1, 3], [1, 10], [1, 11],
* [1, 4], [2, 4], [2, 6], [2, 9], [2, 10],
* [2, 4], [2, 5], [2, 10], [3, 7 ], [3, 7],
* [4, 5], [4, 11], [4, 11], [4, 10], [5, 7],
* [5, 10], [6, 8], [7, 11], [8, 10]]
2
3
        * */
        int n = 12;
        int[][] arr = {{0, 1},{1, 2},{1, 3},{1, 10},{1, 11},
                {1, 4},{2, 4},{2, 6},{2, 9},{2, 10},
                 {2, 4}, {2, 5},{2, 10},{3, 7 },{3, 7},
                {4, 5}, {4, 11},{4, 11},{4, 10},{5, 7},
                 {5, 10},{6, 8},{7, 11},{8, 10}};
        int start = 2;
        int target = 3;
        System.out.println(new 面试题04_01_M_节点间通路().findWhetherExistsPath(n, arr, start, target));
    }
}
