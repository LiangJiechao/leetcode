package offer.s360.s20220924.s1;

import java.util.Scanner;

/**
 * 将长N*M厘米的矩形区域划分成N行M列（每行每列的宽度均为1厘米），
 * 在第i行第j列的位置上叠放Ai,j个边长为1厘米的正方体（1≤Ai,j≤100），
 * 所有正方体就组成了一个立体图形，每个正方体六个面中的一部分会被其它正方体遮挡，
 * 未被遮挡的部分的总面积即为该立体图形的表面积，那么该立体图形的表面积是多少平方厘米？
 *
 * 输入描述
 * 第一行包含两个整数N和M，1≤N，M≤1000。
 *
 * 接下来N行，每行包含M个整数，第i行的第j个整数表示Ai,j。
 *
 * 输出描述
 * 输出表面积的大小。
 *
 * 样例输入
 * 2 2
 * 2 1
 * 1 1
 * 样例输出
 * 20
 * @author xiaoliang
 * @date 2022/09/24 14:11
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();


        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // 正方体个数
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
            }
        }
        int chonghe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]>0){
                    chonghe += arr[i][j] -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (arr[i][j]>0 && arr[i][j-1]>0){
                    chonghe+=Math.min(arr[i][j],arr[i][j-1]);
                }
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]>0 && arr[i-1][j]>0){
                    chonghe+=Math.min(arr[i][j],arr[i-1][j]);
                }
            }
        }
        int area = sum*6 - chonghe*2;
        System.out.println(area);
    }
}
