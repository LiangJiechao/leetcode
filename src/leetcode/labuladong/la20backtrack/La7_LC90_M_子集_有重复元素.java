package leetcode.labuladong.la20backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * @author xiaoliang
 * @date 2022/03/09 11:19
 **/
public class La7_LC90_M_子集_有重复元素 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, path);
        return res;
    }

    private void backtrack(int[] nums, int startIndex, LinkedList<Integer> path) {

        res.add(new ArrayList<>(path));

        for (int i = startIndex; i < nums.length; i++) {

            // 剪掉相同的元素，因为nums是有序的
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.removeLast();

        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        System.out.println(new La7_LC90_M_子集_有重复元素().subsetsWithDup(nums));

//        String str1= "abc";
//        String str2= new String("abc");
//        String str3= str2.intern();
//        System.out.println(str1==str2);
//        System.out.println(str3==str2);
//        System.out.println(str1==str3);

    }

}
