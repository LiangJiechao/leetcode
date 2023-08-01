package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @author xiaoliang
 * @date 2021/12/21 10:05
 **/
public class 剑指Offer62_E_圆圈中最后剩下的数字 {

    /**
     * 模拟法
     * 至于这种思路的代码实现，我尝试了下 LinkedList 会超时，
     * 我猜是因为 LinkedList 虽然删除指定节点的时间复杂度是 O(1) 的，
     * 但是在 remove 时间复杂度仍然是 O(n) 的，因为需要从头遍历到需要删除的位置。
     * 那 ArrayList 呢？索引到需要删除的位置，时间复杂度是 O(1)，
     * 删除元素时间复杂度是 O(n)（因为后续元素需要向前移位），
     * remove 整体时间复杂度是 O(n) 的。
     * 看起来LinkedList 和 ArrayList 单次删除操作的时间复杂度是一样的
     * ArrayList 的 remove 操作在后续移位的时候，其实是内存连续空间的拷贝的！
     * 所以相比于LinkedList大量非连续性地址访问，ArrayList的性能是很 OK 的！
     *
     * @param n 5
     * @param m 3
     * @return
     */
    public int lastRemaining(int n, int m) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 数学方法
     * 总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
     *
     * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
     * 所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
     * 直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
     *
     * 首先最后一轮中num的下标一定是0， 这个是已知的。
     * 那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
     * 再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
     * 再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
     * 再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
     *
     * @param n 5
     * @param m 3
     * @return
     */
    public static int lastRemaining2(int n, int m) {
        // 最后剩下那个数的下标一定是0
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        lastRemaining2(5,3);
    }

}
