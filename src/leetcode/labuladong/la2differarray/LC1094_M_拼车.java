package leetcode.labuladong.la2differarray;

import java.util.Arrays;

/**
 * 假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，
 * 车只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。
 * 这儿有一份乘客行程计划表 trips[][]，
 * 其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：
 * <p>
 * 1 必须接送的乘客数量；
 * 2 乘客的上车地点；
 * 3 以及乘客的下车地点。
 * <p>
 * 请你根据给出的行程计划表和车子的座位数，
 * 来判断你的车是否可以顺利完成接送所有乘客的任务（
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * trips.length <= 1000
 *
 * @author xiaoliang
 * @date 2022/02/23 21:25
 **/
public class LC1094_M_拼车 {

    public boolean carPooling(int[][] trips, int capacity) {
        // 空车
        int[] nums = new int[1001];
        DifferArray differArray = new DifferArray(nums);
        for (int[] trip : trips) {
            int num = trip[0];
            // 第 trip[1] 站乘客上⻋
            int from = trip[1];
            // 第 trip[2] 站乘客已经下⻋，
            // 即乘客在⻋上的区间是 [trip[1], trip[2] - 1]
            int to = trip[2] - 1;
            differArray.increment(from, to, num);
        }

        // 判断能不能一次载完
        int[] result = differArray.result();
//        for (int item : result) {
//            if (item > capacity) {
//                return false;
//            }
//        }
//        return true;
        boolean b = Arrays.stream(result).allMatch(item -> item <= capacity);
        return b;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        LC1094_M_拼车 obj = new LC1094_M_拼车();
        System.out.println(obj.carPooling(trips, capacity));
    }
}
