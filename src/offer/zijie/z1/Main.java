package offer.zijie.z1;

/**
 * 给定一个只有小写字母组成的字符串str，长度为N
 * 给定一个只有0，1组成的数组arr，长度为N
 * arr[i] == 0表示str中i位置的字符不许修改
 * arr[i] == 1表示str中i位置的字符允许修改
 * 给定一个正数m，表示再任一允许修改的位置，可以把该位置的字符编程a~z中的任何一个，
 * 可以修改m次
 * 返回再最多修改m次的情况下，全是一种字符的最长子串是多长
 * 1<= N,M <= 10^5
 * 所有字符都是小写
 *
 * @author xiaoliang
 * @date 2022/09/21 11:22
 **/
public class Main {

    /**
     * 思路：
     * 最大为10^5，所以需要用O(N)或以下的方法，（应为不能超过10^7）
     *
     * @param str
     * @param arr
     * @param m
     * @return
     */
    public static int maxLen3(String str, int[] arr, int m) {
        int n = str.length();
        int initM = m;
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int left = 0;
            int right = 0;
            m = initM; // 重新置为初始值
            while (right < n) {
                char cur = str.charAt(right);
                if (cur == c) {
                    right++;
                } else if (arr[right] == 1 && m > 0) {
                    m--;
                    right++;
                } else {
                    // 缩少窗口
                    if (str.charAt(left) != c && arr[left] == 1) {
                        m++;
                    }
                    if (left == right){
                        right++;
                    }
                    left++;
                }
                res = Math.max(res, right - left);

            }
        }
        return res;
    }



    public static int maxLen2(String str, int[] arr, int m) {
        char[] s = str.toCharArray();
        int n = s.length;
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int right = 0;
            int change = 0;
            for (int left = 0; left < n; left++) {
                while (right < n) {
                    if (s[right] == c) {
                        right++;
                        continue;
                    }
                    if (arr[right] == 0 || change == m) {
                        break;
                    }
                    change++;
                    right++;
                }
                res = Math.max(res, right - left);
                if (s[left] != c && arr[left] == 1) {
                    change--;
                }
                right = Math.max(right, left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbb";
        int[] arr = {1, 1, 0, 1, 1, 1, 1, 0, 1};
        int m = 4;
        // res =
        System.out.println(maxLen3(s, arr, m) == maxLen2(s, arr, m));
        System.out.println(maxLen3(s, arr, m));
        System.out.println(maxLen2(s, arr, m));
    }
}
