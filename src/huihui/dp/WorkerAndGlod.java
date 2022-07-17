package huihui.dp;

/**
 * 动态规划，工人挖金矿
 * @author xiaoliang
 * @date 2021/08/27 11:57
 **/
public class WorkerAndGlod {



    public static void main(String[] args) {

        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};

//        int i = getBestGoldMining(w,p,g);
//        System.out.println("i = " + i);

        // ^ 异或运算，相同为0，不同为1
//        System.out.println(10^10);
    }

    /**
     * 用二维数组实现动态规划
     * @author xiaoliang
     * @date 2021/08/27 12:48
     * @param w 背包大小
     * @param p 物品大小
     * @param g 物品价值
     * @return int
     */
    private static int getBestGoldMining(int w, int[] p, int[] g) {

        int[][] result = new int[g.length+1][w+1];

        for (int i = 1; i <= p.length; i++) {
            for (int j = 1; j <= w; j++) {
                if(j<p[i-1]){
                    result[i][j] = result[i-1][j];
                }else {
                    result[i][j] = Math.max(result[i-1][j],result[i-1][j-p[i-1]]+g[i-1]);
                }
            }

        }

        // 返回最后一个格子
        return result[g.length][w];
    }

    /**
     * 优化，一维数组，从右往左算
     * @author xiaoliang
     * @date 2021/08/27 12:48
     * @param w
     * @param p
     * @param g
     * @return int
     */
    private static int getBestGoldMining2(int w, int[] p, int[] g) {

        int[] result = new int[w+1];
        for (int i = 1; i <= p.length; i++) {
            for (int j = w; j >= 1; j--) {
                if(j >= p[i-1]){
                    result[j] = Math.max(result[j],result[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return result[w];
    }
}
