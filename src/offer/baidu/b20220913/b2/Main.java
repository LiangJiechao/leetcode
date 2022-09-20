package offer.baidu.b20220913.b2;

import java.util.Scanner;

/**
 * 作者：sheensong
 * 链接：https://www.nowcoder.com/discuss/1050330?type=post&order=create&pos=&page=0&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1663126297589
 * 来源：牛客网
 * <p>
 * 第二题 反转01串
 * 小红拿到了一个01串，她每次可以选择一个长度为2的连续子串取反(0变1，1变0)，她想知道，是否能在有限的操作次数内使得所有字符相同?
 * 共有q组询问。
 * <p>
 * 输入描述:
 * 第一行输入一个正整数q，代表询问次数。
 * 每次询问输入一个字符串，仅由'0'和'1'组成。所有字符串长度之和不超过200000。
 * <p>
 * 输出描述:
 * 对于每次询问，如果该字符串可以通过有限的操作使得所有字符相同，则输出"Yes"，否则输出"No"。
 * <p>
 * 示例1
 * 输入输出示例仅供调试，后台判题数据一般不包含示例
 * <p>
 * 输入
 * 1
 * 2
 * 3
 * 4
 * 3
 * 101
 * 1111
 * 1011
 * 输出
 * 1
 * 2
 * 3
 * Yes
 * Yes
 * No
 * 说明
 * 第一组询问，先对前两个字符操作，交成"011"，然后对后两个字符操作，变成"000"。
 * 第二组询问，不需要任何操作。
 * 第三组询问，显然无法通过有效的操作次效使得所有字符相等。
 *
 * @author xiaoliang
 * @date 2022/09/14 11:47
 **/
public class Main {
    //所以当时立马就觉得和字符串中0和1的个数有关，
    // 仔细思考，可以有以下结论：
    // 取反操作可以实现对任意偶数个0或1取反（ 因为通过若干次操作，可以达到【同时翻转任意两个位置的字符】的效果。
    // 具体做法：要想交换第 i 和 j 位（i < j）的字符，只需要依次将 i 和 i+1、i+1和i+2、...、j-1和j交换即可。
    // 途中只有 i 和 j 两个数字反转了一次，其余数字反转了2次所以没有变化）。
    // 因此，只要字符串中 0或1的数量为偶数即可。
    // 意思是可以反转任意两位

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (check(s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean check(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        return zeroCount % 2 == 0 || oneCount % 2 == 0;

    }
}
