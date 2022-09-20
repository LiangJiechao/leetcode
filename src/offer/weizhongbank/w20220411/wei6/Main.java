package offer.weizhongbank.w20220411.wei6;

/**
 * @author xiaoliang
 * @date 2022/04/21 10:38
 **/
public class Main {

    // 找到规定类型的子串的个数
    // 即子串中只能出现 k个c字符的串的个数
    public static int specialStringCount(String s, int k, char c) {

        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String ss = s.substring(i, j);
                if (check(ss, k, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    // 判断是否出现k次
    private static boolean check(String s, int k, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                k--;
            }
        }
        return k == 0;
    }

    public static void main(String[] args) {
        String s = "ababcd";

        System.out.println(specialStringCount(s, 2, 'a'));
    }

}
