package leetcode.labuladong.la28other;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定⼀个仅包含数字 2-9 的字符串，返回所有它能表示的字⺟组合。答案可以按任意顺序 返回。
 * 给出数字到字⺟的映射如下（与电话按键相同）。注意 1 不对应任何字⺟。
 * <p>
 * 输⼊：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * @author xiaoliang
 * @date 2022/03/18 10:09
 **/
public class La1_LC17_电话号码的字母组合 {

    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return res ;
        }
        StringBuilder path = new StringBuilder();
        traverse(digits,0,path);

        return res ;
    }

    private void traverse(String digits, int start, StringBuilder path) {
        if (path.length()==digits.length()){
            res.add(path.toString());
            return;
        }

        for (int j = start; j < digits.length(); j++) {

            int digit = digits.charAt(j) - '0';
            char[] arr = mapping[digit].toCharArray();
            for (char c : arr) {
                path.append(c);
                // 下一个digits上的数字
                traverse(digits, j + 1, path);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new La1_LC17_电话号码的字母组合().letterCombinations("23"));
    }
}
