package zuo.middleascension.class14;

/**
 * 从整体看数组
 * [1 2 3
 *  4 5 6] ==> 124536
 * @author xiaoliang
 * @date 2021/09/26 09:08
 **/
public class Class17_Z字打印数组 {

    public static void printZArr(int[][] arr) {

        if (arr == null) {
            return;
        }
        int a = 0, b = 0, c = 0, d = 0;
        boolean flag = false;
        while (a < arr.length && c < arr.length && b < arr[0].length && d < arr[0].length) {
            printDia(arr, a, b, c, d, flag);
            if (b < arr[0].length - 1) {
                b++;
            }else {
                a++;
            }
            if (c < arr.length - 1) {
                c++;
            }else {
                d++;
            }
            flag = !flag;
        }
    }

    private static void printDia(int[][] arr, int a, int b, int c, int d, boolean flag) {

        if (flag) {
            // 从上往下
            while (a <= c && b >= d) {
                System.out.print(arr[a++][b--]+" ");
            }
        } else {
            //从下往上
            while (a <= c && b >= d) {
                System.out.print(arr[c--][d++]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        printZArr(arr);
    }
}
