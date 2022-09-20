package offer.baidu.b20220913.b1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 作者：sheensong
 * 链接：https://www.nowcoder.com/discuss/1050330?type=post&order=create&pos=&page=0&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1663126297589
 * 来源：牛客网
 * <p>
 * 第一题 百度型字符串
 * 小红拿到了一个字符串，她想知道有多少个"baidu"型子串?所谓"baidu"型字符串，指第1个、第4个字母是辅音，第2、3、5个字来是元音，且每个字母都不相同的字符串。例如，"taigu"、"huida"、"paobu"、"baoli"等都是"baidu"型字符串。
 * <p>
 * 我们定义，元音字母仅有'a'、 'e'、'i'、 'o'、'u'这五种，其余字母均为辅字母。
 * <p>
 * 输入描述:
 * 一个仅由小写字母组成的字符串，长度不超过200000。
 * <p>
 * 输出描述:
 * "baidu"型子串的数量。
 * <p>
 * 示例1
 * 输入输出示例仅供调试，后台判题数据一般不包含示例
 * <p>
 * 输入
 * 1
 * baiduoxiaojiabankanjiaran
 * 输出
 * 1
 * 2
 * 说明
 * 共有"baidu"和"duoxi"这两个baidu型字符串。请注意，"jiaba"和"jiara"并不是baidu型字符串，因为都出现了两个'a '。
 *
 * @author xiaoliang
 * @date 2022/09/14 11:33
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        for (int i = 0; i <= s.length() - 5; i++) {
            if (checkBaidu(set, s.substring(i, i + 5))) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean checkBaidu(Set<Character> set, String s) {
        HashSet<Object> diff = new HashSet<>();
        for (char c : s.toCharArray()) {
            diff.add(c);
        }
        return diff.size() == 5
                && set.contains(s.charAt(1))
                && set.contains(s.charAt(2))
                && set.contains(s.charAt(4))
                && !set.contains(s.charAt(0))
                && !set.contains(s.charAt(3));
    }
}
