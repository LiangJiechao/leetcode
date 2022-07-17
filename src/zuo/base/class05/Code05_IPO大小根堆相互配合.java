package zuo.base.class05;

import java.util.PriorityQueue;

/**
 * 贪心算法：
 * 做项目，使利益最大化 只能做规定次数的项目
 * {花费,利润} ==> 大小根堆配合使用
 * 全部进小根堆，根据花费排序，锁定，
 * 根据现在的资金，将能够投资的项目出队列，放进大根堆，根据收益排序
 *
 * @author xiaoliang
 * @date 2021/09/16 16:09
 **/
public class Code05_IPO大小根堆相互配合 {
    static class Node {
        int cost;
        int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }

        public int getCost() {
            return cost;
        }

        public int getProfit() {
            return profit;
        }
    }

    /**
     * 全部进小根堆，根据花费排序，锁定，
     * 根据现在的资金，将能够投资的项目出队列，放进大根堆，根据收益排序
     *
     * @param k       次数
     * @param w       钱数
     * @param profits 利润数组
     * @param costs   花费数组
     * @return
     */
    public static Integer getMaxProfit(int k, int w, int[] profits, int[] costs) {
        PriorityQueue<Node> minCostQueue = new PriorityQueue<>((o1, o2) -> {
            return o1.cost - o2.cost;
        });
        PriorityQueue<Node> maxProfitQueue = new PriorityQueue<>((o1, o2) -> o2.profit - o1.profit);

        for (int i = 0; i < costs.length; i++) {
            minCostQueue.offer(new Node(costs[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= w) {
                maxProfitQueue.offer(minCostQueue.poll());
            }

            if (maxProfitQueue.isEmpty()) {
                return w;
            }
            Node profitNode = maxProfitQueue.poll();
            w += profitNode.profit;
        }
        return w;
    }

    public static void main(String[] args) {

        Integer maxProfit = getMaxProfit(2, 1, new int[]{4, 5, 1, 3}, new int[]{3, 4, 5, 1});
        System.out.println("maxProfit = " + maxProfit);
    }
}
