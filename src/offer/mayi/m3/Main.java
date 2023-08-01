package offer.mayi.m3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liangjiechao
 * @date 2022/10/11 19:51
 **/
public class Main {

    private static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arr = s.toCharArray();

//        int[] map = new int[26];
//        Set<Character> set = new HashSet<>();
//        for (char c : arr) {
//            map[c - 'a']++;
//            set.add(c);
//        }
//        int moreThan2 = 0;
//        for (int item : map) {
//            if (item >= 2) {
//                moreThan2++;
//            }
//        }
//        System.out.println(moreThan2 * set.size());
//    }
//}

//        Arrays.sort(arr);

        backtrace(arr,0,new StringBuilder());
        System.out.println(res);
    }

    private static void backtrace(char[] arr,int startIndex,StringBuilder sb) {
        if(sb.length()==3){
            System.out.println(sb);
            if(valid(sb.toString())){
                res++;
            }
        }
        for (int i = startIndex; i < arr.length; i++) {

            sb.append(arr[i]);
            backtrace(arr,i+1,sb);
            sb.delete(sb.length() - 1,sb.length());
        }


    }

    private static boolean valid(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        if((arr[0] == arr[1] && arr[0]!=arr[2])
        || (arr[2] == arr[1] && arr[0]!=arr[2])){
            return true;
        }
        return false;
    }
}
