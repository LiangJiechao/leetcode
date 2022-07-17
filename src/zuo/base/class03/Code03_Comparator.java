package zuo.base.class03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器
 * 有默认规则：
 * 返回负数时：第一个参数排前面
 * 返回正数时：第二个参数排前面
 * 返回0时：谁前谁后无所谓
 *
 * @author xiaoliang
 * @date 2021/09/12 20:28
 **/
public class Code03_Comparator {

    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            //防止运算时溢出，用大数类BigInteger， 或者说让两个比较的数先除100再比较
//            BigInteger a = new BigInteger(String.valueOf(o1));
//            BigInteger b = new BigInteger(String.valueOf(o2));
//
//            return a.compareTo(b);
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        // 比较器排序没有考虑溢出的情况
        Integer[] arr = new Integer[]{1, Integer.MAX_VALUE, -5, 1, 1, 0, Integer.MIN_VALUE, -1, 5};
        Arrays.sort(arr, new MyComparator());
        System.out.println(Arrays.toString(arr));
    }
}
