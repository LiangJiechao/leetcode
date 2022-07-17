package zuo.middleascension.class13;

/**
 * 给定字符串，如123 ==> 可翻译位 abc / lc / aw
 *
 * @author xiaoliang
 * @date 2021/09/25 10:53
 **/
public class Class12_尝试匹配出字母 {

    public static int matchWord(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] arr = str.toCharArray();
        return process(arr, 0);
    }

    private static int process(char[] arr, int i) {

        if (i == arr.length) {
            return 1;
        }

        if (arr[i] == '0') {
            return 0;
        } else if (arr[i] == '1') {
            int result = process(arr, i + 1);

            if (i + 1 < arr.length) {
                result += process(arr, i + 2);
            }
            return result;
        } else if (arr[i] == '2') {
            int result = process(arr, i + 1);
            if (i + 1 < arr.length && arr[i + 1] >= '0' && arr[i + 1] <= '6') {
                result += process(arr, i + 2);
            }
            return result;
        } else {
            // 3~9
            return process(arr, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(matchWord("123"));
    }
}
