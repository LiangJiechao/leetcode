package zuo.base.class05;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 贪心算法：
 * 哈夫曼树
 * 最少的钱融化金块
 * offer  poll  peek
 *
 * @author xiaoliang
 * @date 2021/09/16 16:07
 **/
public class Code03_LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
        for (int item : arr) {
            queue.offer(item);
        }

        int sum = 0;
        while (queue.size() > 1) { // >= 2
            Integer value = queue.poll() + queue.poll();
            queue.offer(value);
            sum += value;
        }

        return sum;
    }
}
