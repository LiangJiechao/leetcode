package leetcode;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 *
 * @author xiaoliang
 * @date 2021/12/10 10:08
 **/
public class 剑指_Offer45_M_把数组排成最小的数 {

    /**
     * 思路：贪心算法，排序，比较规则为组合好的大小比较
     *
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {

        String reduce = Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo((o2 + o1)))
                .reduce("", (o1, o2) -> o1 + o2);

//        String string = Arrays.stream(nums).boxed().sorted((i1, i2) -> {
//            String s1 = "" + i1 + i2;
//            String s2 = "" + i2 + i1;
//            return s1.compareTo(s2);
//        }).map(i -> i.toString()).reduce("", (i1, i2) -> i1 + i2);

        return reduce;
    }

    public static void main(String[] args) {
//        System.out.println("0123".compareTo("1230"));
        int[] nums = {3, 30, 34, 5, 9, 0, 0, 0};
        System.out.println(minNumber(nums));
    }

}
