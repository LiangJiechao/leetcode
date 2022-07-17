package offer.huawei.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有A，B两个同学想要分苹果。
 * A的想法是使用二进制进行，1 + 1相加不进一位，如（9 + 5 = 1001 +101 = 12）。
 * B同学的想法是使用十进制进行，并且进一位。
 * 会输入两组数据，一组是苹果总数，一组分别是每个苹果的重量。
 * 如果让B同学在满足A同学的情况下获取到苹果的总重量且返回，如果不能则返回-1。
 *
 * 输入
 * 3
 * 3 5 6
 *
 * 返回
 * 11
 *
 * 备注：按照A同学的想法 5 + 6 =  3  101 + 110 = 011
 * @author xiaoliang
 * @date 2022/03/29 11:14
 **/
public class 分苹果 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = scanner.nextInt();
        }

        // 按照A的想法，如果能后平分，那么所有重量异或后就==0
        int xor = 0;
        for (int i = 0; i <n ; i++) {
            xor ^= nums[i];
        }

        if (xor==0){
            // 能平分
            Arrays.sort(nums);
            // B能拿的最大重量：就是n-1个最大重量的苹果
            int bSum = 0;
            for (int i = 1; i < n; i++) {
                bSum += nums[i];
            }
            System.out.println(bSum);
        }else {
            // 不能平分
            System.out.println(-1);
        }
    }

}
