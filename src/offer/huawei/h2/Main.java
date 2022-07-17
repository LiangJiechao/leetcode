package offer.huawei.h2;

import java.util.Scanner;

/**
 * 作者：牛客433911733号
 * 链接：https://www.nowcoder.com/discuss/919142?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1651025920168
 * 来源：牛客网
 * <p>
 * 2.不同路径升级版，指路--> https://leetcode-cn.com/problems/unique-paths-ii/
 * 给一个地图的长宽，给起点和终点的坐标，给障碍物个数和坐标，求最短路径长度和个数
 * 输入：
 * 5 5
 * 0 1
 * 3 3
 * 1
 * 1 2
 * 输出：
 * 5 4
 *
 * @author xiaoliang
 * @date 2022/03/30 18:57
 **/
public class Main {

    /**
     * 5 5
     * 0 1
     * 3 3
     * 1
     * 2 2
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] graph = new int[m][n];
        int[] start = new int[2];
        start[0] = scanner.nextInt();
        start[1] = scanner.nextInt();

        int[] end = new int[2];
        end[0] = scanner.nextInt();
        end[1] = scanner.nextInt();
        int hu = scanner.nextInt();
        for (int i = 0; i < hu; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 2;
        }
        int[][] visited = new int[m][n];
        dfs(graph, start[0], start[1], end[0], end[1], 0, visited);
        System.out.println(minPathNum + " " + minPath);

    }

    static int minPath = Integer.MAX_VALUE;
    static int minPathNum = 0;
    static int[] direction = {-1, 0, 1, 0, -1};

    private static void dfs(int[][] graph, int si, int sj, int ei, int ej, int path, int[][] visited) {
        if (si < 0 || si >= graph.length
                || sj < 0 || sj >= graph[0].length
                || graph[si][sj] == 2 || visited[si][sj] == 1) {
            return;
        }
        if (si == ei && sj == ej) {
            if (path < minPath) {
                minPath = path;
                minPathNum = 1;
            } else if (path == minPath) {
                minPathNum++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            path++;
            visited[si][sj] = 1;
            dfs(graph, si + direction[i], sj + direction[i + 1], ei, ej, path, visited);
            visited[si][sj] = 0;
            path--;
        }
    }
}
