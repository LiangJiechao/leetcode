package leetcode.labuladong.la23dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xiaoliang
 * @date 2022/04/06 22:33
 **/
public class LC518_M_零钱兑换II {

    /*
        完全背包问题：一个硬币可以用多次
        比较要注意的一点是问题求解是组合数而不是排序数 这一点与遍历顺序有关
        1.定义：dp[j] 用coins数组的硬币凑齐总金额j有dp[i]种方式
        2.递推公式：dp[j] += dp[j-coin[i]]
        3.初始化：金额为0时 无为而治 dp[0] = 1
        4.遍历顺序 先遍历硬币再遍历金额 依次从小到大遍历
            要注意的是遍历金额时是要从小到大遍历的 这与01背包不同
            因为完全背包中的物品是可以重复使用的 因此从小到大遍历 在从前往后推的过程中复用前面的状态 以达到复用的效果
        5.测试数据：coins:[2,1] amount:5
            todo 比较不同的遍历顺序有什么区别：
            先遍历硬币再遍历金额 硬币的顺序是固定不变的 结果为:[[2,2,1],[2,1,1][1,1,1]] 1不可能出现在2的前面
            而先遍历金额再遍历硬币 就不一样了 是与之不同的排序数 这时[2,2,1]和[2,1,2]就是两种不一样的情况了
            与题意中要求的组合数不同
    */

    // 压缩空间，注意循环的次序不能写反
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1;i<=amount;i++){
                if(i-coin>=0){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }


    public int change2(int amount, int[] coins) {
        int[][] dp = new int[amount+1][coins.length];
        for (int i = 0; i <coins.length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >=0){
                    dp[i][j] += dp[i-coins[j]][j];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[amount][coins.length-1];
    }
}
