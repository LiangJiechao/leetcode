package offer.zhongxin20220829.z2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 作者：LeetCode-Solution
 *     链接：https://leetcode.cn/problems/binary-watch/solution/er-jin-zhi-shou-biao-by-leetcode-solutio-3559/
 *     来源：力扣（LeetCode）
 *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author xiaoliang
 * @date 2022/08/29 19:37
 **/
public class Main {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1024; ++i) {
            int h = i >> 6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Integer a = -128;
        Integer b = -128;
        System.out.println(a==b);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> res = new ArrayList<>();

        if (n >= 9) {
            System.out.println(res);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(1);
        }
        int min = Integer.parseInt(sb.toString(), 2);

        for (int i = 0; i < 10 - n; i++) {
            sb.append(0);
        }
        int max = Integer.parseInt(sb.toString(), 2);

        for (int num = min; num <= max; num++) {
            String binaryNum = fillLeftZero(Integer.toBinaryString(num));
            if (numOfOne(binaryNum)!=n){
                continue;
            }
            String left = binaryNum.substring(0, 4);
            String right = binaryNum.substring(4);
            if (valid(left, right)) {
                res.add(getTime(left,right));
            }
        }
        System.out.println(res);
    }

    private static int numOfOne(String binaryNum) {
        int count = 0;
        for (char c : binaryNum.toCharArray()) {
            if (c=='1'){
                count++;
            }
        }
        return count;
    }

    private static String fillLeftZero(String str) {

        int n = 10;
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - len; i++) {
             sb.append("0");
        }
        return sb.toString()+str;
    }

    private static String getTime(String left, String right) {
        Integer leftTime = Integer.valueOf(left, 2);
        Integer rightTime = Integer.valueOf(right, 2);
        String time = leftTime+":";
        if(rightTime<=9){
            time+="0"+rightTime;
        }else {
            time+=rightTime;
        }
        return time;
    }

    private static boolean valid(String left, String right) {

        if (Integer.valueOf(left, 2) <= 11 && Integer.valueOf(right, 2) <= 59) {
            return true;
        }
        return false;
    }

}
