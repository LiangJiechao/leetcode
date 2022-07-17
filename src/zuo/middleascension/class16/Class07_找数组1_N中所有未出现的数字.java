package zuo.middleascension.class16;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一整数数组，长度为n，有 1<=arr[i]<=n，且对于[1,n]的整数，其中部分整数会重复出现，而部分不会出现，
 * 请找出[1,n]中所有未出现的数字
 *
 * @author xiaoliang
 * @date 2021/10/09 20:19
 **/
public class Class07_找数组1_N中所有未出现的数字 {

    /**
     * 思路：鹊巢原理
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                adjust(nums, i);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i+1);
            }
        }
        return list;
    }

    private static void adjust(int[] arr, int i) {

        while (arr[arr[i] - 1] != arr[i] ) {
            int temp = arr[arr[i] - 1];
            arr[arr[i]-1] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr).toString());
    }



}
