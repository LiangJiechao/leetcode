package offer.merituan2021;

import java.util.Scanner;

/**https://leetcode-cn.com/leetbook/read/meituan/oh4ykh/
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，
 * 一个合法的用户名必须满足以下几个要求：
 * <p>
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 *
 * @author xiaoliang
 * @date 2022/03/13 17:34
 **/
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (judge(s)) {
                System.out.println("Accept");
            } else {
                System.out.println("Wrong");
            }

        }
    }

    /**
     * * 用户名的首字符必须是大写或者小写字母。
     * * 用户名只能包含大小写字母，数字。
     * * 用户名需要包含至少一个字母和一个数字。
     *
     * @param s
     * @return
     */
    private static boolean judge(String s) {
        if (s.length() < 2) {
            return false;
        }
        char[] arr = s.toCharArray();
        int numCnt = 0;

        if ((arr[0] >= 'a' && arr[0] <= 'z')
                || (arr[0] >= 'A' && arr[0] <= 'Z')) {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] >= '0' && arr[i] <= '9') {
                    numCnt++;
                    continue;
                }
                if ((arr[i] >= 'a' && arr[i] <= 'z')
                        || (arr[i] >= 'A' && arr[i] <= 'Z')) {

                } else {
                    // 出现非字母
                    return false;
                }
            }
            return numCnt > 0;

        } else {
            return false;
        }

    }
}
