package b;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author xiaoliang
 * @date 2021/12/03 09:36
 **/
public class 找未来出现的回文日期 {

    public static List<String> getPalindromeDate(int num) {
        LinkedList<String> res = new LinkedList<>();

        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(-10);
        for (int i = 1; i <= num; i++) {
            LocalDate plusDays = date.plusDays(i);
            String s = plusDays.toString().replaceAll("-", "");
            if (isPalindrome(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        DateFormat format = DateFormat.getDateInstance();
//        LocalDate now = LocalDate.now();
//        String s = now.toString().replaceAll("-", "");

//        List<String> list = getPalindromeDate(10000);
//        list.forEach(System.out::println);


    }

    static class OddNumberPredicate implements Predicate<Integer> {
        // 判断奇数
        @Override
        public boolean test(Integer num) {
            return num % 2 == 1;
        }
    }



}





