package leetcode;

import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 * @author xiaoliang
 * @date 2021/11/09 10:17
 **/
public class LC1046_E_最后一块石头的重量 {

    /**
     * 思路：用大根堆，
     * 1.每次选出两个元素
     * 2.敲碎，如果大于1则放回堆中， 如果为0则不用处理
     * 循环1，2
     * 直到堆大小为 0或1，返回堆顶
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        // 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() >= 2) {
            int s1 = heap.poll();
            int s2 = heap.poll();

            if (s1 - s2 != 0) {
                heap.offer(s1 - s2);
            }
        }
        return heap.size() == 0 ? 0 : heap.peek();
    }

}
