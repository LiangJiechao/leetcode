package offer.meituan2022.meituan0827.m3;

import java.util.Arrays;
import java.util.LinkedList;
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

        String big = scanner.next();

        int[] guest = new int[m];
        for (int i = 0; i < m; i++) {
            guest[i] = scanner.nextInt();
        }
        String[] small = new String[m];
        for (int i = 0; i < m; i++) {
            small[i] = scanner.next();
        }

        int sum = Arrays.stream(guest).sum();
        if (sum != n){
            System.out.println(0);
            return ;
        }

        Arrays.sort(small);
        boolean[] used = new boolean[small.length];
        LinkedList<String> path = new LinkedList<>();
        dfs(small,used,path,big);
        System.out.println(res);
//        System.out.println(repeat);
    }
    /*
    *   8 3
        aaaaaaaa
        4 2 2
        aaaa
        aa
        aa
    * */
    static int res = 0;
//    static int repeat = 0;
    private static void dfs(String[] small, boolean[] used, LinkedList<String> path , String big) {

        if (path.size() == small.length){
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            if (sb.toString().equals(big)){
                res++;
            }
            return;
        }
        for (int i = 0; i < small.length; i++) {
            if (used[i]){
                continue;
            }
            if (i>0 && used[i-1] && small[i].equals(small[i-1]) ){
//                repeat++;
                continue;
            }
            used[i] = true;
            path.add(small[i]);

            dfs(small,used,path,big);

            path.removeLast();
            used[i] = false;

        }
    }
}
