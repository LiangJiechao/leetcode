package b;

import java.util.Arrays;

/**
 * @description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @author xiaoliang
 * @date 2021/6/25 10:04
 * @version 1.0
 */
public class LongestCommonPrefix {

    //先利用Arrays.sort(strs)为数组排序，再将数组第一个元素和最后一个元素的字符从前往后对比即可！
    public static String longestCommonPrefix(String[] strs) {
        //鲁棒性检查
        for (int i = 0; i < strs.length; i++) {
            if(strs[i]==null || strs[i].isEmpty()){
                return "";
            }
        }

        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        int m = strs[0].length();
        int n = strs[strs.length-1].length();
        int num = Math.min(m,n);

        for (int i = 0; i < num; i++) {
            if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "customer", "car", "cat" };
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }
    
}
