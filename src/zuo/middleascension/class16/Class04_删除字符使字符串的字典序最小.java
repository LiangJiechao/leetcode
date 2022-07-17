package zuo.middleascension.class16;

/**
 * 给定一个全是小写字母的字符串str，删除多余字符，使得每种字符只保留一个，
 * 并让最终结果字符串的字典序最小
 * 如 str="dbcacbca" 删除第一个b，第一个c，第二个c，第二个a，得到 dabc最小字典序
 * 贪心算法：先记录词频，第二次遍历时，如果遇到词频-- 等于0时，就把该字符及其前的串中找到最小的asc码字符的下标，
 * 把该下标前的串都删掉，把后串中 该最小的asc码字符删掉
 *
 * @author xiaoliang
 * @date 2021/10/09 10:44
 **/
public class Class04_删除字符使字符串的字典序最小 {

    public static String getLowestLexicography(String str) {

        if (str == null || str.length() < 2) {
            return str;
        }

        int[] cnt = new int[26];

        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }

        int minAcsIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            // 一边判断，一边记录最小ACS码的下标
            minAcsIndex = str.charAt(minAcsIndex) > str.charAt(i) ? i : minAcsIndex;
            if (--cnt[str.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        return String.valueOf(str.charAt(minAcsIndex))
                + getLowestLexicography(str.substring(minAcsIndex + 1).replaceAll(String.valueOf(str.charAt(minAcsIndex)), ""));
    }

    private static void check(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("参数错误");
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] >= 'a' && arr[i] <= 'z')) {
                throw new RuntimeException("参数错误");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aacbca";
        check(str);
        System.out.println(getLowestLexicography(str));
    }
}
