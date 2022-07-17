package zuo.base.class06;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力递归，打印所有子集
 *
 * @author xiaoliang
 * @date 2021/09/16 16:12
 **/
public class Code02_PrintAllSubSet打印所有子集 {

    /**
     * 方法1
     * 全部子集，共有2^n种可能（如果包括空集）
     *
     * @param str
     * @return
     */
    public static List<String> printAllSubSet1(String str) {

        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] arr = str.toCharArray();
        List<String> list = new ArrayList<>();

        int maxNum = 1 << arr.length; // 2^n
        for (int i = 0; i < maxNum; i++) { // 处理0到2^n  -1之间的数字
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) { // 表示当前位不为0,则需要打印相应的字母
//                    System.out.print(arr[j]);
                    sb.append(arr[j]);
                }
            }
            list.add(sb.toString());

        }
        return list;
    }

    public static void printAllSubSet2(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        process(str.toCharArray(), 0);
    }

    /**
     * 方法2
     * 用系统栈去保留
     *
     * @param str
     * @param i
     */
    public static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str).replaceAll("#", ""));
            return;
        }
        process(str, i + 1);
        char temp = str[i];
        str[i] = '#';
        process(str, i + 1);
        // 还原回来
        str[i] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";

        List<String> list = printAllSubSet1(s);
        System.out.println(list);
        printAllSubSet2(s);
    }

}
