package zuo.middleascension.class14;

/**
 * 从整体看数组
 * [1 2 3
 * 4 5 6
 * 7 8 9]  ==> 123698745
 *
 * @author xiaoliang
 * @date 2021/09/26 09:07
 **/
public class Class15_二维数组旋转打印 {

    public static void printSpiralArr(int[][] arr) {
        if (arr == null) {
            return;
        }
        int a = 0, b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a <= c && b <= d) {
            printDia(arr, a++, b++, c--, d--);
        }
    }

    /**
     * 打印 对角的边上的元素
     *
     * @param arr 要打印的数组
     * @param a   左上角的横坐标
     * @param b   左上角的纵坐标
     * @param c   右下角的横坐标
     * @param d   右下角的纵坐标
     */
    public static void printDia(int[][] arr, int a, int b, int c, int d) {

        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.print(arr[a][i]);
            }
        } else if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.print(arr[i][b]);
            }
        } else {
            for (int i = b; i < d; i++) {
                System.out.print(arr[a][i]);
            }
            for (int i = a; i < c; i++) {
                System.out.print(arr[i][d]);
            }
            for (int i = d; i > b; i--) {
                System.out.print(arr[c][i]);
            }
            for (int i = c; i > a; i--) {
                System.out.print(arr[i][b]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        printSpiralArr(arr);
    }

}
