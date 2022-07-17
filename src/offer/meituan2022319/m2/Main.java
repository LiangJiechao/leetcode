package offer.meituan2022319.m2;

import java.util.Scanner;

/**
 * 对于一个长度为n的字符串s，其对应的加密字符串t的第一个字符是s中的第n/2个字符（向上取整）， 而t中第二到第n个字符则刚好对应 s删去第n/2个字符（向上取整）后所得字符串的加密字符串。 这个规则也可以用如下流程描述：
 * 将t初始化为一个空串，不断地从s中取出第n/2个字符（向上取整）并将其拼到t的后面， 当s为空时t即是所求的加密字符串。
 *
 * 为了加快破解流程，小团希望你能设计一个命令行工具来帮他进行加密和解密的操作
 * 
 * @author xiaoliang
 * @date 2022/03/19 10:32
 **/
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        String s = scanner.next();
        String res = "";
        if (t == 1) {
            // 加密
            char[] arr = new char[s.length()];
            int index = 0;
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() != 0) {
                int mid = (sb.length() - 1) / 2;
                char c = sb.charAt(mid);
                arr[index++] = c;
                sb.deleteCharAt(mid);
            }
            res = new String(arr);
        } else if (t == 2) {
            // 解密
            char[] arr = new char[s.length()];
            int left = 0;
            int right = arr.length - 1;
            int index = s.length() - 1;
            boolean flag = true;
            while (left <= right) {
                if (flag) {
                    arr[right] = s.charAt(index);
                    right--;
                    index--;
                    flag = false;
                } else {
                    arr[left] = s.charAt(index);
                    left++;
                    index--;
                    flag = true;
                }
            }
            res = new String(arr);

        }

        System.out.println(res);
    }
}
