package leetcode.labuladong.la20backtrack;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/04/11 16:47
 **/
public class LC37_H_解数独 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {

        if (j == 9) {
            return backtrack(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }

        if (board[i][j] != '.') {
            // 有预设数字
            return backtrack(board, i, j + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c)) {
                continue;
            }
            board[i][j] = c;
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }

        // 一般走不到这里
        return false;

    }

    // 判断在 board[i][j] 位置插入 c合不合法
    private boolean isValid(char[][] board, int i, int j, char c) {

        for (int k = 0; k < 9; k++) {

            if (board[i][k] == c) {
                return false;
            }
            if (board[k][j] == c) {
                return false;
            }
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == c) {
                return false;
            }

        }
        return true;
    }
}
