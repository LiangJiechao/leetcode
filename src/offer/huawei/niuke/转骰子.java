package offer.huawei.niuke;

import java.util.Scanner;

/**
 * 作者：XiaJun
 * 链接：https://www.nowcoder.com/discuss/914921
 * 来源：牛客网
 *
 * 骰子是一个正方体，每个面有一个数字，初始为左1，右2，前3，后4，上5，下6，
 * 用123456表示这个状态,放置在平面上，
 * 可以向左翻转（用L表示向左翻转1次）；
 * 可以向右翻转（用R表示向右翻转1次）；
 * 可以向前翻转（用F表示向前翻转1次）；
 * 可以向后翻转（用B表示向后翻转1次）；
 * 可以逆时针翻转（用A表示向逆时针翻转1次）；
 * 可以向顺时针翻转（用C表示向顺时针翻转1次）
 *
 * 题目可以点进链接看图解
 * 输入一行指令，输出最后骰子的状态
 *
 * 输入
 * RL
 * 输出
 * 123456
 * 解释：骰子向右转一下，再向左转一下，各面结果相当于不变
 * @author xiaoliang
 * @date 2022/03/29 16:36
 **/
public class 转骰子 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arr = s.toCharArray();

        // 代表 ： {冗余，左，右，前，后，上，下}
        int[] status = {-1,1,2,3,4,5,6};
        for (char c : arr) {
            if (c=='L'){
                // 左右上下这4个交换
                int temp = status[1];
                status[1] = status[5];
                status[5] = status[2];
                status[2] = status[6];
                status[6] = temp;
            }else if (c=='R'){
                int temp = status[1];
                status[1] = status[6];
                status[6] = status[2];
                status[2] = status[5];
                status[5] = temp;
            }else if (c=='F'){
                int temp = status[3];
                status[3] = status[5];
                status[5] = status[4];
                status[4] = status[6];
                status[6] = temp;
            }else if (c=='B'){
                int temp = status[3];
                status[3] = status[6];
                status[6] = status[4];
                status[4] = status[5];
                status[5] = temp;
            }else if (c=='A'){
                int temp = status[3];
                status[3] = status[2];
                status[2] = status[4];
                status[4] = status[1];
                status[1] = temp;
            }else if (c=='C'){
                int temp = status[3];
                status[3] = status[1];
                status[1] = status[4];
                status[4] = status[2];
                status[2] = temp;
            }
        }
        for (int i = 1; i < status.length; i++) {
            System.out.print(status[i]);
        }
    }
}
