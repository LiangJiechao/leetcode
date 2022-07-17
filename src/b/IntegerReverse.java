package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 * @date 2021/6/27 21:10
 */
public class IntegerReverse {

    public int reverse(int x) {
        //记录符号，测试过，不用判断符号也行
//        int flag = x < 0 ? 1 : 0;
        int reverseNum = 0;
//        int cur = Math.abs(x);
        int cur = x;
        while (cur != 0) {
            //判断溢出，意味着在加一位就会溢出
            if (reverseNum < Integer.MIN_VALUE / 10 || reverseNum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverseNum = 10 * reverseNum + cur % 10;
            cur /= 10;
        }
//        return flag == 1 ? -reverseNum : reverseNum;
        return reverseNum;
    }
}
