package offer.meituan2022.meituan0820.m4;

/**
 * 作者：王悟空
 * 链接：https://www.nowcoder.com/discuss/1021857?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1661004640205
 * 来源：牛客网
 * <p>
 * 小美的火箭有一些地方坏了，为了修补一个地方，需要使用材料压着，幸好她有很多种这样的材料。
 * 火箭上有n个地方坏了，每个地方至少需要bi单位重量的材料压住
 * 小妹有m种材料，每种材料重量为ai; m种材料不限量
 * 同时要求：一个地方只能使用一个材料，材料需要尽量小。
 * <p>
 * 输入：n、m
 * 输入n个数代表b序列
 * 输入m个数代表a序列
 * <p>
 * 输出最小总重量，如果没法满足，输出-1。
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * input:
 * 3 3
 * 4 1 3
 * 4 2 1
 * <p>
 * output:
 * 9  原因： 4+1+4
 *
 * @author xiaoliang
 * @date 2022/08/20 23:37
 **/
public class 修补 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        int max = Arrays.stream(arr1).max().getAsInt();
        Arrays.sort(arr2);

        if (max > arr2[m - 1]) {
            System.out.println(-1);
            return;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int target = arr1[i];
            // 找到arr2种 >= arr1[i]的最小的值
            int left = 0;
            int right = m - 1;
            int first = m - 1;

            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (arr2[mid] >= target) {
                    first = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res += arr2[first];
        }
        System.out.println(res);
    }
}
