package leetcode;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * 输入：board = [["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * @author xiaoliang
 * @date 2021/12/07 18:57
 **/
public class 剑指Offer12_M_矩阵中的路径 {

    /**
     * 深度优先遍历，回溯
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, visited, i, j, word, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        // 左 上 右 下
        int[] direction = {-1, 0, 1, 0, -1};

        for (int k = 0; k < direction.length - 1; k++) {
            int i = direction[k], j = direction[k + 1];
            if (row + i >= 0 && row + i < board.length
                    && col + j >= 0 && col + j < board[0].length
                    && visited[row + i][col + j] == false
                    && board[row + i][col + j] == word.charAt(index)) {
                visited[row + i][col + j] = true;
                if (dfs(board, visited, row + i, col + j, word, index + 1)) {
                    return true;
                }
                visited[row + i][col + j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//         * 输入：board = [["A","B","C","E"],
// *               ["S","F","C","S"],
// *               ["A","D","E","E"]], word = "ABCCED"
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCC";
        exist(board, word);
    }

}
