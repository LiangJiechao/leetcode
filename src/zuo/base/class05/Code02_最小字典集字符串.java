package zuo.base.class05;

import java.util.Arrays;

/**
 * 贪心算法：
 * 最小字典集字符串
 * 给定一字符串数组，求拼起来后让其字典序更低
 * 错误的贪心：直接比较字符串的字典序，反例：b,ba   b<ba  但 bba>bab
 * 正确的贪心：用结合后比较，如a,b  ab<ba  所以 a<b
 *
 * @author xiaoliang
 * @date 2021/09/16 16:03
 **/
public class Code02_最小字典集字符串 {

    public static String lowestLexicography(String[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("参数错误");
        }
        Arrays.sort(arr, (o1, o2) -> {
            return (o1 + o2).compareTo(o2 + o1);
        });
        StringBuilder sb = new StringBuilder();
        for (String item : arr) {
            sb.append(item);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
        System.out.println(lowestLexicography(strs1));

        String[] strs2 = {"ba", "b"};
        System.out.println(lowestLexicography(strs2));
    }
}
