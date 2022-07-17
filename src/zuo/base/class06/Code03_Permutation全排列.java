package zuo.base.class06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 暴力递归，字符串全排列
 *
 * @author xiaoliang
 * @date 2021/09/16 16:13
 **/
public class Code03_Permutation全排列 {

    public static List<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        return res;
    }

    /**
     * 相当于第1个元素跟后面的所有元素依次交换，然后排除第一个元素；开始用第二个元素与后面的元素进行交换...
     * @param chars
     * @param i
     * @param res
     */
    private static void process(char[] chars, int i, List<String> res) {

        if (i == chars.length) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        // 依次与后面的元素交换
        for (int j = i; j < chars.length; j++) {
            if (set.add(chars[j])) {
                swap(chars, i, j);
                process(chars, i + 1, res);
                swap(chars, i, j);
            }
        }

    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        List<String> res = permutation("aba");
        res.forEach(x -> System.out.println(x));
    }
}
