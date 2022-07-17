package zuo.base.class05;

/**
 * N皇后问题
 * int i = -1;
 * System.out.println(Integer.toBinaryString(i));//全1
 *
 * @author xiaoliang
 * @date 2021/09/16 16:11
 **/
public class Code09_NQueen {

    /**
     * 优化法：使用位运算来加速8皇后问题的计算
     *
     * @param n
     * @return
     */
    public static int nQueue2(int n) {

        if (n < 4) {
            // 3皇后及以下都没有解
            return 0;
        }
        if (n > 32) {
            // 3皇后及以下都没有解
            throw new RuntimeException("参数大于32，该函数计算不了，需要改long类型");
        }
        // limit 表示几皇后，1的地方可以放皇后，也间接表示了record数组
        int limit = n == 32 ? -1 : ((1 << n) - 1);

        return process2(limit, 0, 0, 0);
    }

    /**
     * @param limit
     * @param colLim      列限制
     * @param leftDiaLim  左对角限制：可以通过colLim左移实现
     * @param rightDialim 右对角限制：可以通过colLim无符号右移实现
     * @return
     */
    private static int process2(int limit, int colLim, int leftDiaLim, int rightDialim) {

        if (colLim == limit) {
            // base case: 说明已经全部皇后都填了
            return 1;
        }
        // 所有可以填皇后的列都在这个位信息上
        // pos上的1表示可以放皇后的位置
        // todo limit 是为了截掉 8皇后 前面所有的 0（不能填皇后的位置）
        int pos = limit & (~(colLim | leftDiaLim | rightDialim));
        // 获取二进制中最右边的1
        int mostRightOne = 0;

        int res = 0;
        while (pos != 0) {
            // 或 mostRightOne = pos & (~pos + 1); 或 mostRightOne = pos & (-pos);
            mostRightOne = pos & (~pos + 1);
            pos -= mostRightOne;

            // 这里的左对角线限制，因为需要进入下一行，所以是当前左限制 或上 新插入的位置后 再整体左移
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDialim | mostRightOne) >>> 1);


        }
        return res;
    }

    public static int nQueue1(int n) {

        if (n < 4) {
            // 3皇后及以下都没有解
            return 0;
        }
        // 记录每行皇后列的位置
        int[] record = new int[n];

        return process1(0, record, n);
    }

    /**
     * @param i      表示第i行的皇后
     * @param record record[0~i-1]中已拜摆好皇后的位置
     * @param n      表示共有几行
     * @return
     */
    private static int process1(int i, int[] record, int n) {

        if (i == n) {
            // 表示摆好了一种，才有可能 i == n
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 判断在第i行j列上放皇后，会不会与前面i-1上的皇后有冲突
     *
     * @param record
     * @param i 行
     * @param j 列
     * @return
     */
    private static boolean isValid(int[] record, int i, int j) {

        for (int k = 0; k < i; k++) {
            // record[k] == j 表示在(i,j)放入的的皇后与前面已放的皇后处于同一列
            // Math.abs(k - i) == Math.abs(record[k] - j) 表示在(i,j)放入的的皇后与前面已放的皇后处于 统一对角线上
            if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("nQueue2(9) = " + nQueue2(9));
        System.out.println("耗时==>" + (System.currentTimeMillis() - start) + "毫秒");
        long start2 = System.currentTimeMillis();
        System.out.println("nQueue1(9) = " + nQueue1(9));
        System.out.println("耗时==>" + (System.currentTimeMillis() - start2) + "毫秒");
    }
}
