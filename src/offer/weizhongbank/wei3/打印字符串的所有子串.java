package offer.weizhongbank.wei3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoliang
 * @date 2022/04/12 16:57
 **/
public class 打印字符串的所有子串 {

    List<String> res = new ArrayList<>();

    public List<String> getAllSubString(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                res.add(s.substring(i, j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 打印字符串的所有子串().getAllSubString("123"));
    }
}
