package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author xiaoliang
 * @date 2021/12/02 17:47
 **/
public class 剑指Offer57II_E_和为s的连续正数序列 {


    /**
     * 思路：滑动窗口，
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {

        List<int[]> list = new LinkedList<>();

        int sum = 0;
        int left = 1;
        int right = 1;
        for (; right < target; right++) {
            sum += right;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                list.add(temp);
            }
        }

        // handle result
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        findContinuousSequence(15);

//        Integer a = 123456;
//        Integer b = 123456;
//        System.out.println(a==b); // false 要用equal比较

//        String str = "a,b,c,,";
//        String[] ary = str.split(",");
//        // 预期大于 3，结果是 3
//        System.out.println(ary.length);
//        Arrays.stream(ary).forEach(System.out::print);// abc

//        List<String> list = new ArrayList<String>();
//        list.add("guan");
//        list.add("bao");
//        list.add("a1");
//        list.add("b1");
//        list.add("c1");
//        list.add("d1");
//        List<String> subList = list.subList(2, 5);
//
//        for (String s : subList) {
//            s = s.substring(0, 1);
//        }
//        subList.add("add");
//        System.out.println(subList);
//        System.out.println(list);

//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        for (int i = 0; i < 200; i++) {
//            System.out.println(random.nextInt(1, 101));
//        }
    }
}
