package leetcode.labuladong.la22bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 *
 * @author xiaoliang
 * @date 2022/03/10 11:05
 **/
public class La3_LC773_H_滑动谜题 {

    // 记录每个位置的相邻的格子 对应字符串的下标
    int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    /**
     * 思路：将board转换为字符串来处理，用BFS
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        // 转为字符串
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        String init = sb.toString();
        String target = "123450";

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(init);
        visited.add(init);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if (poll.equals(target)) {
                    return step;
                }
                // 找到0的下标
                int idx = poll.indexOf("0");
                for (int nei : neighbor[idx]) {
                    String newBoard = swap(poll, idx, nei);
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }

}
