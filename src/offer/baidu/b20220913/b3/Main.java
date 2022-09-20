package offer.baidu.b20220913.b3;

import java.util.Scanner;

/**
 * 作者：sheensong
 * 链接：https://www.nowcoder.com/discuss/1050330?type=post&order=create&pos=&page=0&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1663126297589
 * 来源：牛客网
 * <p>
 * 第三题 字符矩阵最小移动步数
 * 小红拿到了一个字符矩阵，矩阵仅由'r、'e'、'd'三种字符组成。她初始站在左上角，每次可以走到一个相邻的字符上(每个字符上、下、左、右最多4个相邻)。但有个限制，小红不能从'r走到d'，从'e'走到r' ,从'd'走到e'，其他情况都能走。
 * 小红想知道，从左上角走到右下角至少需要多少步?
 * <p>
 * 输入描述:
 * 第一行输入两个正整数n和m，代表矩阵的行数和列数。
 * 接下来的n行，每行输入一个长度为m的字符串，用来表示矩阵。
 * 1≤n, m ≤500
 * <p>
 * 输出描述:
 * 如果小红无法到达右下角，则输出-1。
 * 否则输出一个整数，代表小红的最少移动步数。
 * <p>
 * 示例1
 * 输入输出示例仅供调试，后台判题数据一般不包含示例
 * <p>
 * 输入
 * 1
 * 2
 * 3
 * 4
 * 3 3
 * red
 * der
 * rdr
 * 输出
 * 1
 * 4
 * 说明
 * 小红可以走r →e →e → d →r，共需要移动4步。
 *
 * @author xiaoliang
 * @date 2022/09/14 14:27
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        dfs(arr, 0, 0, n, m, 0, visited);
        System.out.println(res);

//        int[][] dp = new int[n][m];
//        // init
//        boolean flag = false;
//        for (int i = 1; i < m; i++) {
//            if ((arr[0][i] == 'd'&& arr[0][i-1] == 'r')
//            || (arr[0][i] == 'r'&& arr[0][i-1] == 'e')
//            || (arr[0][i] == 'e'&& arr[0][i-1] == 'd')
//            ){
//                flag = true;
//            }
//            if (flag){
//                dp[0][i]=0;
//
//            }
//        }
    }

    static int res = Integer.MAX_VALUE;

    private static void dfs(char[][] arr, int row, int col, int n, int m, int step, boolean[][] visited) {
        if (row < 0 || row >= n || col < 0 || col >= m) {
            return;
        }

        if (row == n - 1 && col == m - 1) {
            res = Math.min(res, step);
            return;
        }

        for (int i = 0; i < direction.length - 1; i++) {
            char curChar = arr[row][col];
            int nextRow = row + direction[i];
            int nextCol = col + direction[i + 1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) {
                continue;
            }
            if (visited[nextRow][nextCol]
                    || (arr[nextRow][nextCol] == 'd' && curChar == 'r')
                    || (arr[nextRow][nextCol] == 'r' && curChar == 'e')
                    || (arr[nextRow][nextCol] == 'e' && curChar == 'd')
            ) {
                continue;
            } else {
                visited[row][col] = true;
                step++;
                dfs(arr, nextRow, nextCol, n, m, step, visited);
                step--;
                visited[row][col] = false;

            }
        }

    }

    static int[] direction = {-1, 0, 1, 0, -1};
}
