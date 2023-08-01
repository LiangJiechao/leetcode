package leetcode.labuladong.la23dp.sanyedp;

import java.util.Arrays;

/**
 * 给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。
 * 同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
 * <p>
 * 输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
 * 输出：4
 * 解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
 * 1 -> 3
 * 1 -> 2 -> 3
 * 1 -> 4 -> 3
 * 1 -> 4 -> 2 -> 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-all-possible-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/04/26 14:32
 **/
public class S7_La1575_H_统计所有可行路径 {

    // dp方法
    public int countRoutes(int[] locations, int start, int end, int fuel) {

        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];

        for (int i = 0; i <= fuel; i++) {
            dp[end][i] = 1;
        }

        for (int cur = 0; cur <= fuel; cur++) {
            for (int i = 0; i < n; i++) {

                for (int k = 0; k < n; k++) {
                    if (k != i) {
                        int need = Math.abs(locations[k] - locations[i]);
                        if (cur >= need) {
                            dp[i][cur] += dp[k][cur - need];
                            dp[i][cur] %= mod;
                        }
                    }
                }

            }
        }

        return dp[start][fuel];
    }

    int mod = 1000000007;
    int[][] memory;

    // dfs方法
    public int countRoutes2(int[] locations, int start, int end, int fuel) {

        int n = locations.length;
        memory = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i], -1);
        }

        return dfs(locations, start, end, fuel);

    }

    /**
     * 计算「路径数量」
     *
     * @param locations 入参 locations
     * @param cur       当前所在位置（locations 的下标）
     * @param end       目标哦位置（locations 的下标）
     * @param fuel      剩余油量
     * @return 在位置 cur 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
     */
    private int dfs(int[] locations, int cur, int end, int fuel) {

        // 如果缓存中已经有答案，直接返回
        if (memory[cur][fuel] != -1) {
            return memory[cur][fuel];
        }

        // 如果一步到达不了，说明从位置 cur 不能到达 end 位置
        // 将结果 0 写入缓存器并返回
        int need = Math.abs(locations[cur] - locations[end]);
        if (need > fuel) {
            memory[cur][fuel] = 0;
            return 0;
        }

        int sum = cur == end ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            if (i != cur) {
                need = Math.abs(locations[cur] - locations[i]);
                if (fuel >= need) {
                    sum += dfs(locations, i, end, fuel - need);
                    sum %= mod;
                }
            }
        }
        memory[cur][fuel] = sum;
        return sum;
    }

}
