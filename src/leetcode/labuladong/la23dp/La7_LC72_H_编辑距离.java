package leetcode.labuladong.la23dp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * @author xiaoliang
 * @date 2022/03/10 22:11
 **/
public class La7_LC72_H_编辑距离 {

    /*
    对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
    以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
    (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2]）
    (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
    (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
    */

    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        // dp[i][j]代表arr1[0..i]和arr2[0..j]的最小变换次数
        // arr1[0..i] 变成 arr2[0..j] 的最小变换次数
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] =  i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }

        }
        return dp[m][n];
    }

    /** 感觉有点问题 (代价 2 3 4 )  horse -> ros == 8
     * 从 word1 变 word2 的最小代价
     *
     * @param word1
     * @param word2
     * @param add   添加元素的代价
     * @param sub   删除元素的代价
     * @param swap  替换元素的代价
     * @return
     */
    public int minDistanceWithPrice(String word1, String word2, int add, int sub, int swap) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        // dp[i][j]代表arr1[0..i] 变成 arr2[0..j]的最小代价
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + add;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + add;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + swap,
                            Math.min(dp[i - 1][j] + add, dp[i][j - 1] + sub));
                }
            }

        }
        return dp[m][n];
    }

    class Node {
        // 当前 dp[i][j]代表arr1[0..i]和arr2[0..j]的最小变换次数
        int val;

        // 通过什么操作变换
        // 0.代表啥都不做
        // 1.代表添加
        // 2.代表删除
        // 3.代表替换
        int option;

    }
    // TODO: 2022/4/18  输出变换过程
    public int minDistanceWithOption(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int m = arr1.length;
        int n = arr2.length;
        // dp[i][j]代表arr1[0..i]和arr2[0..j]的最小变换次数
        // arr1[0..i] 变成 arr2[0..j] 的最小变换次数
        Node[][] dp = new Node[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = new Node();
            }
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0].val = i;
            dp[i][0].option = 2;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i].val = i;
            dp[0][i].option = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j].val = dp[i - 1][j - 1].val;
                    dp[i][j].option = 0;
                } else {
                    dp[i][j].val = 1 + Math.min(dp[i - 1][j - 1].val, Math.min(dp[i - 1][j].val, dp[i][j - 1].val));
                    if (dp[i][j].val == dp[i - 1][j - 1].val + 1) {
                        dp[i][j].option = 3;
                    } else if (dp[i][j].val == dp[i - 1][j].val + 1) {
                        dp[i][j].option = 1;
                    } else if (dp[i][j].val == dp[i][j - 1].val + 1) {
                        dp[i][j].option = 2;
                    }
                }
            }
        }

        printProcess(dp);

        return dp[m][n].val;
    }

    // TODO: 2022/4/18  输出变换过程
    private void printProcess(Node[][] dp) {
        int m = dp.length;
        int n = dp[0].length;
        int i = m-1;
        int j = n-1;
        Deque<String> stack = new LinkedList<>();

        while (i>=0&&j>=0){
            Node choice = dp[i][j];
            switch (choice.option){
                case 0:
                    stack.offerLast("什么都不做");
                    break;
                case 1:
                    stack.offerLast("添加");
                    j--;
                    break;
                case 2:
                    stack.offerLast("删除");
                    i--;
                    break;
                case 3:
                    stack.offerLast("替换");
                    i--;
                    j--;
                    break;
                default:break;
            }
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pollLast());
        }

    }

    public static void main(String[] args) {
        System.out.println(new La7_LC72_H_编辑距离().minDistanceWithOption("horse", "ros"));
    }

}
