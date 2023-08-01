package offer.mayi.m1;

import java.util.Scanner;

/**
 * @author liangjiechao
 * @date 2022/10/11 18:59
 **/
public class Main {

    // 1 -- 98765
    // 6 -- 98760
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int res = 0;
        int num = 98765;
        while (n>0){
            if(valid(num)){
                res = num;
                n--;
            }
            num--;
        }
        System.out.println(res);
    }

    private static boolean valid(int num) {

        String s = String.valueOf(num);
        if (s.length()<4){
            return false;
        }
        if (s.length() == 4){
            s = "0"+s;
        }
        boolean[] val = new boolean[10];
        for (char c : s.toCharArray()) {
            if (val[c-'0']== false){
                val[c-'0'] = true;
            }else {
                return false;
            }
        }
        return  true;
    }
}
