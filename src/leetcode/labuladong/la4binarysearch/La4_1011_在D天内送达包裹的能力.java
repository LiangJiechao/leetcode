package leetcode.labuladong.la4binarysearch;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。
 * 每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * @author xiaoliang
 * @date 2022/02/24 17:06
 **/
public class La4_1011_在D天内送达包裹的能力 {

    /**
     * 假定「D 天内运送完所有包裹的最低运力」为 ans，那么在以 ans 为分割点的数轴上具有「二段性」：
     * <p>
     * 数值范围在 (-\infty, ans)(−∞,ans) 的运力必然「不满足」 D 天内运送完所有包裹的要求
     * 数值范围在 [ans, +\infty)[ans,+∞) 的运力必然「满足」 D天内运送完所有包裹的要求
     * 即我们可以通过「二分」来找到恰好满足 D天内运送完所有包裹的分割点 ans。
     * <p>
     * 接下来我们要确定二分的范围，由于不存在包裹拆分的情况，考虑如下两种边界情况：
     * <p>
     * 最小取值 货物最大值；最大取值，一次运走全部sum
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        // 最小取值 货物最大值；最大取值，一次运走全部sum
        int left = max, right = sum;
        int mostLeft = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(weights, mid, days)) {
                right = mid-1;
                mostLeft = mid;
            } else {
                left = mid + 1;
            }
        }
        return mostLeft;
    }

    /**
     * 检查在capacity容量情况下，能不能在规定天数内全部运输完成
     * @param weights 全部货物
     * @param capacity 一次运输的最大容量
     * @param days 规定天数
     * @return
     */
    private boolean check(int[] weights, int capacity, int days) {
        int needDay = 0;
        int n = weights.length;
        for (int i = 0, sum = 0; i < n; ) {
            needDay++;
            while (i < n && sum + weights[i] <= capacity) {
                sum += weights[i];
                i++;
            }
            sum = 0;
        }
        // 1,2,3,4,5,   6,7,  8,  9,  10
        return needDay <= days;
    }
}
