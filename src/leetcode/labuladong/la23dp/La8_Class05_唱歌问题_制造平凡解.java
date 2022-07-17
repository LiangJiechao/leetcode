package leetcode.labuladong.la23dp;

/**
 * 递归条件不够，制造平凡解
 * 女主播唱歌，开始人气值为start，要晋升下一轮需要人气刚好达到end，土豪给主播增加人气的可以采取的方法有：
 * a.点赞  花费x个币，人气+2
 * b.送礼  花费y个币，人气*2
 * c.私聊  花费z个币，人气-2
 * 其中end远大于start且为偶数，问最少花费多少币就能帮助主播达到end人气
 * 如 x y z start end = 3 100 1 2 6 ==> 输出  6
 * <p>
 * 分析，如果直接递归的话，因为递归 base case条件不够，会导致递归无法终止
 * 所以要根据题意，人为地制造平凡解
 * 一个最普通的平凡解，就是直接由点赞得到目标人气
 * 还有就是目前人气不可能是超过目标人气的两倍（因为如果出现这种情况，可以在end人气时*2得到）
 *
 * @author xiaoliang
 * @date 2021/10/09 11:48
 **/
public class La8_Class05_唱歌问题_制造平凡解 {


    public static int minCoin(int start, int end, int x, int y, int z) {

        int commonResult = (end - start) / 2 * x;

        return process(0, start, end, x, y, z, commonResult, end * 2);
    }

    /**
     * @param curCoin   当前币数
     * @param start     开始人气
     * @param end       目标人气
     * @param add       人气+2需要的币
     * @param multi     人气*2需要的币
     * @param sub       人气-2需要的币
     * @param limitCoin 平凡解需要的币数
     * @param limitAim  最多不能超过多少人气
     * @return
     */
    private static int process(int curCoin, int start, int end, int add, int multi, int sub, int limitCoin, int limitAim) {

        if (curCoin > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (start < 0 || start >= limitAim) {
            return Integer.MAX_VALUE;
        }
        if (start == end) {
            return curCoin;
        }

        int min = limitCoin;
        int p1 = process(curCoin + add, start + 2, end, add, multi, sub, limitCoin, limitAim);
        int p2 = process(curCoin + multi, start * 2, end, add, multi, sub, limitCoin, limitAim);
        int p3 = process(curCoin + sub, start - 2, end, add, multi, sub, limitCoin, limitAim);

        return Math.min(min, Math.min(p3, Math.min(p1, p2)));
    }

    public static void main(String[] args) {
        // 2 6 3 100 1
        System.out.println(minCoin(2, 6, 3, 100, 1));
    }
}
