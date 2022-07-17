package zuo.middleascension.class13;

/**
 * 简单版：((())())
 * 升级版：要加多少括号才完整
 *
 * @author xiaoliang
 * @date 2021/09/25 09:26
 **/
public class Class08_括号匹配问题 {

    // 简单版:((())())
    public static boolean check1(String str) {

        char[] arr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            } else if (arr[i] == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    // 升级版:要加多少括号才完整
    public static int check2(String str) {

        char[] arr = str.toCharArray();
        int count = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                count++;
            } else if (arr[i] == ')') {
                if (count == 0) {
                    res++;
                }else {
                    count--;
                }
            }
        }
        return res+count;
    }

    public static void main(String[] args) {
        String s1 = "(a(v(das)dasd)dasd())";
        System.out.println(check1(s1));
        System.out.println(check2(s1));

        String s2 = "((dasd())(()))dasd)())";
        System.out.println(check1(s2));
        System.out.println(check2(s2));
    }
}
