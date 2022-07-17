package offer.tengxun.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个数组，下标从1-n，每次淘汰下标非质数的数字，然后重新组成数组，问最后剩下的数字为何数？
 * 题目：删除非质数下标输出最后元素
 * [3,1,1,4,5,6]
 * 5
 *
 * @author xiaoliang
 * @date 2022/04/24 19:56
 **/
public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 1, 1, 4, 5, 6};
        System.out.println(new Main().getNumber(nums));
    }

    //[3,1,1,4,5,6]
    //5
    public int getNumber(int[] arr) {

        List<Integer> list = new ArrayList<>();

        while (list.size() != 1) {
            list.clear();
            for (int i = 0; i < arr.length; i++) {
                if (isEven(i + 1)) {
                    list.add(arr[i]);
                }
            }
            arr = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return list.get(0);

    }

    private boolean isEven(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;

    }
}
