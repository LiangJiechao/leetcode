package offer.merituan2021;

import java.util.Scanner;

/**
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，
 * 每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。
 * 已知货物入库的时候是按顺序堆放在一起的。
 * 如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 *
 * 已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,小美会根据单据依次不放回的取出货物。
 * 请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 * 输入：
 *      5
 *      3 2 4 4 5
 *      4 3 5 2 1
 * 输出：
 *      9
 *      5
 *      5
 *      3
 *      0
 *
 * @author xiaoliang
 * @date 2022/03/13 17:50
 **/
public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w =new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=scanner.nextInt();
        }


        for (int i = 0; i < n; i++) {
            int get = scanner.nextInt();

        }
    }
}
