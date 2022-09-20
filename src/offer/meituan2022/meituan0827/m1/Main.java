package offer.meituan2022.meituan0827.m1;

import java.util.Scanner;

/**
 * 
 * @author xiaoliang
 * @date 2022/08/27 15:54
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        int res = 0;
        char start = t.charAt(0);
        for (int i = 0; i <= n - m; i++) {
            if (s.charAt(i) ==start || start=='*'){
                String substring = s.substring(i, i + m);
                if (valid(substring,t)){
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    private static boolean valid(String s, String t) {

        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(i)=='*' || s.charAt(i)==t.charAt(i)){
                continue;
            }else {
                return false;
            }
        }
        return true;

    }
}
