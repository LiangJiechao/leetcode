package leetcode.labuladong2.la02_diffarr;

/**
 * https://leetcode.cn/problems/corporate-flight-bookings/
 *
 * @author liangjiechao
 * @date 2023/05/15 14:05
 **/
public class La01_LC1109_M_航班预订统计 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        DiffArr diffArr = new DiffArr(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            diffArr.increase(i, j, val);
        }
        return diffArr.result();

    }

    class DiffArr {
        private int[] diffarr;

        public DiffArr(int[] num) {
            assert num.length > 0;
            int len = num.length;
            diffarr = new int[len];

            // 构造差分数组
            diffarr[0] = num[0];
            for (int i = 1; i < len; i++) {
                diffarr[i] = num[i] - num[i - 1];
            }
        }

        // 在[i,j]范围增加val
        public void increase(int i, int j, int val) {
            diffarr[i] += val;
            if (j < diffarr.length - 1) {
                diffarr[j + 1] -= val;
            }
        }

        // 返回原数组和结果
        public int[] result() {
            int len = diffarr.length;
            int[] res = new int[len];
            res[0] = diffarr[0];
            for (int i = 1; i < len; i++) {
                res[i] = res[i - 1] + diffarr[i];
            }
            return res;
        }
    }
}
