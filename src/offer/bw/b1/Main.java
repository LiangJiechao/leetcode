package offer.bw.b1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 编程题
 * 1. 有序int数组的多路归并
 * 给定N（N<=1024）个int数组，每个int[]的值都是有序的
 * 这些数组的长度不一定相同（在0到1000000随机）
 * 请用尽可能最高效的方式来归并有序输出每个数组中都包含的元素（各数组中AND条件归并）
 * int[] andMerge(int[N][]) {
 * …
 * }
 * <p>
 * 例如：
 * int[] a = {1,3,4,6,7,8,9,10}
 * int[] b = {2,4,6,8,10}
 * int[] c = {5,6,7,8,9,11,12,13,14}
 * 归并的结果为：6, 8
 *
 * @author liangjiechao
 * @date 2022/10/10 20:18
 **/
public class Main {


    int[] andMerge(int[][] arrs) {

        int n = arrs.length;
        // 每个数组当前遍历的位置下的值
        int[] cur = new int[n];
        // 每个数组的长度
        int[] lens = new int[n];
        // 每个数组的指针
        int[] p = new int[n];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int i = 0; i < n; i++) {
            priorityQueue.add(new int[]{i, arrs[i][0]});
            lens[i] = arrs[i].length;
            cur[i] = arrs[i][0];
        }
        List<Integer> res = new ArrayList<>();

        while (priorityQueue.size() == n) {
            if (judge(cur)) {
                res.add(cur[0]);
            }
            // 推出最小元素
            int[] poll = priorityQueue.poll();
            int curIndex = poll[0];
            if (p[curIndex] == lens[curIndex]) {
                break;
            }
            p[curIndex]++;
            cur[curIndex] = arrs[curIndex][p[curIndex]];
            priorityQueue.offer(new int[]{poll[0],cur[curIndex]});

        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean judge(int[] nums) {
        return Arrays.stream(nums).allMatch(item->item==nums[0]);
    }


}
