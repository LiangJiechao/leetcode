package zuo.baseascension.class08;

import java.util.*;

/**
 * 单调栈应用：记录数组中每个元素离他最近的，左边和右边的比该元素较大的值
 *
 * @author xiaoliang
 * @date 2021/09/19 21:05
 **/
public class Code04_MonotonousStack {

    /**
     * 记录数组中每个元素离他最近的，左边和右边的比该元素较大的值
     *
     * @param arr 原始数组
     * @return
     */
    public static Integer[][] getNearMore(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }
        // 因为考虑到有相同元素的情况
        // Deque<Integer> deque = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        Integer[][] res = new Integer[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            // 如果新进的元素比栈顶的元素大，弹出
            while (!stack.isEmpty() && arr[stack.peek().get(0)] < arr[i]) {
                List<Integer> pop = stack.pop();
                for (Integer ele : pop) {
                    res[ele][0] = stack.isEmpty() ? null : stack.peek().get(stack.peek().size() - 1);
                    res[ele][1] = i;
                }
            }
            // 添加新元素入栈
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                // stack不为空且最后一个列表的元素与当前新增元素大小一样
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 最后剩下的元素
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            for (Integer ele : pop) {
                res[ele][0] = stack.isEmpty() ? null : stack.peek().get(stack.peek().size() - 1);
                res[ele][1] = null;
            }
        }
        return res;
    }

    /**
     * 记录数组中每个元素离他最近的，左边和右边的比该元素较小的值
     *
     * @param arr 原始数组
     * @return
     */
    public static Integer[][] getNearLess(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }
        // 因为考虑到有相同元素的情况
//        Deque<Integer> deque = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();

        Integer[][] res = new Integer[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            // 如果新进的元素比栈顶的元素小，弹出
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> pop = stack.pop();
                for (Integer ele : pop) {
                    res[ele][0] = stack.isEmpty() ? null : stack.peek().get(stack.peek().size() - 1);
                    res[ele][1] = i;
                }
            }
            // 添加新元素入栈
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                // stack不为空且最后一个列表的元素与当前新增元素大小一样
                stack.peek().add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        // 最后剩下的元素
        while (!stack.isEmpty()) {
            List<Integer> pop = stack.pop();
            for (Integer ele : pop) {
                res[ele][0] = stack.isEmpty() ? null : stack.peek().get(stack.peek().size() - 1);
                res[ele][1] = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 3, 5, 6, 43, 6, 4};

        Integer[][] nearLess = getNearLess(arr);
        for (Integer[] less : nearLess) {
            for (Integer i : less) {
                System.out.print(" " + i);
            }
            System.out.println();
        }

        System.out.println("-------------");

        int[] arr2 = new int[]{1, 3, 1};
        Integer[][] nearMore = getNearMore(arr2);
        for (Integer[] more : nearMore) {
            for (Integer i : more) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

}
