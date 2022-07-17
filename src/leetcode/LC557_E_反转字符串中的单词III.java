package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * @author xiaoliang
 * @date 2021/10/21 17:13
 **/
public class LC557_E_反转字符串中的单词III {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            throw new RuntimeException("参数错误");
        }
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        char[] arr;
        for (int i = 0; i < split.length; i++) {
            arr = split[i].toCharArray();
            reverseString(arr);
            sb.append(arr);
            if (i != split.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 双指针法，两个相互交换
     *
     * @param arr
     */
    public static void reverseString(char[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(char[] arr, int L, int R) {
        char temp;
        while (L < R) {
            temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
            L++;
            R--;
        }
    }

    public static void main(String[] args) {
//        String str = "Let's take LeetCode contest";
//        System.out.println(reverseWords(str));

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();

        Iterator<Integer> iterator = list.iterator();
        //增强型for循环底层就是用iterator实现的
        int ddd= 0;
        while (iterator.hasNext()) {
            ddd += iterator.next();
        }
        System.out.println(System.nanoTime() - start);
        System.out.println(ddd);


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start2 = System.nanoTime();
        ddd=0;
        for (Integer item : list) {
            ddd += item;
        }
        System.out.println(System.nanoTime() - start2);
        System.out.println(ddd);
    }
}
