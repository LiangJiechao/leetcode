package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * @author xiaoliang
 * @date 2021/10/29 10:28
 **/
public class LC77_M_组合 {

    // TODO: 2021/10/29  
    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> track = new LinkedList<>();
        process(n,k,1,track,result);
        return result;
        
    }

    private static void process(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size()==k){
            result.add(new ArrayList<>(track));
            return;
        }

        // 例如：
//        n = 15 ，k = 4。
//        path.size() == 1 的时候，接下来要选择 33 个数，搜索起点最大是 1313，最后一个被选的是 [13, 14, 15]；
//        path.size() == 2 的时候，接下来要选择 22 个数，搜索起点最大是 1414，最后一个被选的是 [14, 15]；
//        path.size() == 3 的时候，接下来要选择 11 个数，搜索起点最大是 1515，最后一个被选的是 [15]

        // i <=  n - (k - track.size()) + 1 属于剪枝  还需要的元素个数为: k - track.size();
        for (int i= start; i <=  n - (k - track.size()) + 1; i++) {
            // 控制树的横向遍历
            track.add(i);
            // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            process(n,k,i+1,track,result);
            // 回溯，撤销处理的节点
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combine(5, 3);
        for (List<Integer> l1 : list) {
            for (Integer item : l1) {
                System.out.print(item);
            }
            System.out.println();
        }

    }

}
