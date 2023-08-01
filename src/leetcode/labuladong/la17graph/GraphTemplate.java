package leetcode.labuladong.la17graph;

/**
 * @author xiaoliang
 * @date 2022/03/06 16:41
 **/
public class GraphTemplate {

    // 记录被遍历过的节点
    boolean[] visited;
    // 记录从起点到当前节点的路径
    /*这个 onPath 数组的操作很像 回溯算法核⼼套路 中做「做选择」和「撤销选择」，
    区别在于位置：回溯算法的「做选择」和「撤销选择」在 for 循环⾥⾯，
    ⽽对 onPath 数组的操作在 for 循环外⾯
    为什么有这个区别呢？这就是前文 回溯算法核心套路 中讲到的回溯算法和 DFS 算法的区别所在：回溯算法关注的不是节点，而是树枝。*/
    boolean[] onPath;
    /* 图遍历框架 */
//    void traverse(Graph graph, int s) {
//        if (visited[s]) return;
//        // 经过节点 s，标记为已遍历
//        visited[s] = true;
//        // 做选择：标记节点 s 在路径上
//        onPath[s] = true;
//        for (int neighbor : graph.neighbors(s)) {
//            traverse(graph, neighbor);
//        }
//        // 撤销选择：节点 s 离开路径
//        onPath[s] = false;
//    }

//    // DFS 算法，关注点在节点
//    void traverse(TreeNode root) {
//        if (root == null) return;
//        printf("进入节点 %s", root);
//        for (TreeNode child : root.children) {
//            traverse(child);
//        }
//        printf("离开节点 %s", root);
//    }
//
//    // 回溯算法，关注点在树枝
//    void backtrack(TreeNode root) {
//        if (root == null) return;
//        for (TreeNode child : root.children) {
//            // 做选择
//            printf("从 %s 到 %s", root, child);
//            backtrack(child);
//            // 撤销选择
//            printf("从 %s 到 %s", child, root);
//        }
//    }

}
