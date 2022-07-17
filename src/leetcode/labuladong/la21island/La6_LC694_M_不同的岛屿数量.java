package leetcode.labuladong.la21island;

import java.util.HashSet;
import java.util.Set;

/**
 * 题⽬还是输⼊⼀个⼆维矩阵，0 表示海⽔，1 表示陆地，这次让你计算不同的 (distinct) 岛屿数量
 * <p>
 * 其中有四个岛屿，但是左下⻆和右上⻆的岛屿形状相同，所以不同的岛屿共有三个，算法返回 3
 * <p>
 * 很显然我们得想办法把⼆维矩阵中的「岛屿」进⾏转化，变成⽐如字符串这样的类型，然后利⽤ HashSet 这
 * 样的数据结构去重，最终得到不同的岛屿的个数。
 * 如果想把岛屿转化成字符串，说⽩了就是序列化，序列化说⽩了就是遍历嘛，前⽂ ⼆叉树的序列化和反序列化
 * 讲了⼆叉树和字符串互转，这⾥也是类似的。
 *
 * @author xiaoliang
 * @date 2022/03/09 20:17
 **/
public class La6_LC694_M_不同的岛屿数量 {

    // 用字符串记录岛屿的形状
    // 遍历过程中 上下左右 分别为 wsad
    int numDistinctIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, 'X');
                    set.add(sb.toString());
                }
            }

        }

        return set.size();

    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, char direction) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(direction).append(",");
        dfs(grid, i + 1, j, sb, 'w');
        dfs(grid, i - 1, j, sb, 's');
        dfs(grid, i, j - 1, sb, 'a');
        dfs(grid, i, j + 1, sb, 'd');

    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}};
        System.out.println(new La6_LC694_M_不同的岛屿数量().numDistinctIslands(grid));
    }
}
