package zuo.middleascension.class14;

/**
 * 从整体看数组
 *
 * @author xiaoliang
 * @date 2021/09/26 09:07
 **/
public class Class16_正方形二维数组旋转90度 {

    public static void rotateArr(int[][] arr) {
        if (arr == null || arr.length != arr[0].length) {
            throw new RuntimeException("参数错误");
        }
        int a = 0, b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;

        while (a <= c && b <= d) {
            // i 代表组数
            for (int i = 0; i < c - a; i++) {
                int temp = arr[a][b + i];
                arr[a][b + i] = arr[c - i][b];
                arr[c - i][b] = arr[c][d - i];
                arr[c][d - i] = arr[a + i][d];
                arr[a + i][d] = temp;
            }
            a++;
            b++;
            c--;
            d--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateArr(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

