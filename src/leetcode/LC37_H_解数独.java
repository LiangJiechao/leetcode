package leetcode;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * @author xiaoliang
 * @date 2022/02/17 16:14
 **/
public class LC37_H_解数独 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public boolean backtrack(char[][] board, int i, int j) {
        // base case
        if (j == 9) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            // 如果有预设数字，不用我们穷举
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';

        }

        return false;
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

        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
            if (board[k][j] == c) {
                return false;
            }
            if (board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
