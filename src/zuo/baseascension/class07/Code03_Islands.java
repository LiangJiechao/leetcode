package zuo.baseascension.class07;

/**
 * 算出右多少个岛屿
 * 可以用递归算出
 *
 * @author xiaoliang
 * @date 2021/09/18 15:01
 **/
public class Code03_Islands {

    public static int countIslands(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return 0;
        }

        int row = arr.length;
        int col = arr[0].length;

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j, row, col);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] arr, int i, int j, int row, int col) {

        // base case
        if (i < 0 || i == row || j < 0 || j == col || arr[i][j] != 1) {
            return;
        }
        // 感染
        arr[i][j] = 2;
        infect(arr, i - 1, j, row, col);
        infect(arr, i + 1, j, row, col);
        infect(arr, i, j - 1, row, col);
        infect(arr, i, j + 1, row, col);
    }

    public static void main(String[] args) {
        int[][] m1 = {  {0, 1, 1, 1, 0, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0, 0, 0, 1, 0},
                        {0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 0, 0},};
        System.out.println(countIslands(m1));

        int[][] m2 = {  {0, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 0, 0, 0, 1, 0},
                        {0, 1, 1, 0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 0, 0}};
        System.out.println(countIslands(m2));
    }

}
