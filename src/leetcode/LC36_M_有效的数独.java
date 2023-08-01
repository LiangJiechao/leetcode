package leetcode;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *  
 *
 * @author xiaoliang
 * @date 2021/12/25 09:57
 **/
public class LC36_M_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValid(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 判断在 i,j 位置插入 c合法不合法
     *
     * @param board
     * @param i
     * @param j
     * @param c
     * @return
     */
    private boolean isValid(char[][] board, int i, int j, char c) {
        // 除了 i.j 位置
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == c) {
                return false;
            }
            if (k != i && board[k][j] == c) {
                return false;
            }
            if (((i / 3) * 3 + k / 3 != i && (j / 3) * 3 + k % 3 != j)
                    && board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {

        int[][] row = new int[9][10]; // 行代表在第几行，列代表是哪个数字
        int[][] col = new int[9][10]; // 行代表在第几列，列代表是哪个数字
        int[][] box = new int[9][10]; // 行代表在第几个box，列代表是哪个数字
        // 怎么根据i,j确定是在哪个box(是由i,j共同决定的)
        /**如何判定board[i][j]在第几个box呢？
         * 显然属于第几个box由i和j的组合唯一确定，例如board[2][2]一定是第0个box，
         * board[4][7]一定是第5个box，可以画出来看一下，但是规律在哪里呢？
         * 我们可以考虑一种简单的情况： 一个3x9的矩阵，被分成3个3x3的box，如图：
         * 显然每个数属于哪个box就只取决于纵坐标，纵坐标为0/1/2的都属于box[0],纵坐标为3/4/5的都属于box[1],
         * 纵坐标为6/7/8的都属于box[2].也就是j/3.
         *
         * 而对于9x9的矩阵，我们光根据j/3得到0/1/2还是不够的，可能加上一个3的倍数，
         * 例如加0x3,表示本行的box，加1x3，表示在下一行的box，加2x3，表示在下两行的box，
         * 这里的0/1/2怎么来的？和j/3差不多同理，也就是i/3。
         *
         */

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
                // 同时判断这个数在其所在的列有没有出现过
                // 同时判断这个数在其所在的box中有没有出现过
                if (board[i][j] == '.') {
                    continue;
                }
                int curNum = board[i][j] - '0';
                if (row[i][curNum] == 1) {
                    return false;
                }
                if (col[j][curNum] == 1) {
                    return false;
                }
                if (box[(i / 3) * 3 + j / 3][curNum] == 1) {
                    return false;
                }

                // 之前都没出现过，现在出现了，就给它置为1，下次再遇见就能够直接返回false了。
                row[i][curNum] = 1;
                col[j][curNum] = 1;
                box[(i / 3) * 3 + j / 3][curNum] = 1;
            }
        }
        return true;
    }

}
