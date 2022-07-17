package b;

/**
 * @author xiaoliang
 * @version 1.0
 * @description: 剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * @date 2021/6/25 15:12
 */
public class StrToInt {

    public static int strToInt(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        //符号位
        int flag = 0;
        if (chars[0] == '+') {
            flag = 1;
        } else if (chars[0] == '-') {
            flag = 2;
        }

        int start = flag == 0 ? 0 : 1;
        int res = 0;
        int temp;
        for (int i = start; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                temp = chars[i] - '0';
                res = res * 10 + temp;
            } else {
                return 0;
            }
        }

        return flag == 2 ? (-res) : res;
    }

    public static void main(String[] args) {
        String s = "-12312312";
        System.out.println("使用库函数转换：" + Integer.valueOf(s));
        System.out.println("使用自己写的方法转换：" + StrToInt.strToInt(s));
    }
}
