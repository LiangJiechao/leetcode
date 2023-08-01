package offer.jingdong.j2;

import java.util.Scanner;

/**
 * 作者：mp-ui
 * 链接：https://www.nowcoder.com/discuss/922391?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1651028784144
 * 来源：牛客网
 *
 * 输入整数n和长度为3n的字符串s，字符串只包含ABC三个字符，你的每一次操作都可以将s中的连续字符全部变成ABC任意一种，问：最少多少次操作，可以使得s中最后ABC的数量相同？
 * 思路：答案只可能是0 1 2三种
 *
 * 如果s中ABC的数量相等，直接输出0
 * 如果s中ABC中只有一个字符的数量是小于n的，就用滑动窗口判断，成功就输出1
 * 其他情况输出2
 *
 * 比如n=3，A有1个，B和C加起来8个，那么A还差2个，
 * 就维护大小为2的滑动窗口，把滑动窗口里面的全部换成A，看存不存在一种情况，使得ABC都是3个
 * @author xiaoliang
 * @date 2022/04/02 18:57
 **/
public class Main {

    public static void main(String[] args) {

        /*todo
        3
        2
        ABACBC
        3
        AAABBBBAC
        3
        CAACBCBCC
*/

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {

            int n = scanner.nextInt();
            String s = scanner.next();
            print(n,s.toCharArray());

        }
    }

    private static void print(int n, char[] arr) {

        int[] count = new int[3];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]-'A']++;
        }

        if (count[0]==n&&count[1]==n&&count[2]==n){
            System.out.println(0);
        }else {
            //
            int index = 0;
            int lessThanNCnt = 0;
            for (int i = 0; i < 3; i++) {
                if (count[i]<n){
                    lessThanNCnt++;
                    index = i;
                }
            }
            // 如果s中ABC中只有一个字符的数量是小于n的，就用滑动窗口判断，成功就输出1
            // 其他情况输出2
            if (lessThanNCnt>1){
                System.out.println(2);
            }else {
                // 用滑动窗口判断 todo
                int windowSize = n - count[index];
                int left = 0;
                int right = 0;


            }



//
        }


    }
}
