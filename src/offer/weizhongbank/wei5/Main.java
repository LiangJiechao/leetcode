package offer.weizhongbank.wei5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author xiaoliang
 * @date 2022/04/21 11:07
 **/
public class Main {

    public static int incrArrCountDp(int[] arr) {

        int len = arr.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] < arr[j]) {
                    dp[j] += dp[i];
                }
            }
        }

        int res = Arrays.stream(dp).sum();
        return res;

    }

    // 求递增子序列个数，可用 dp
    public static int incrArrCount(int[] arr) {

        dfs(arr, 0, new LinkedList<Integer>());

        return res;
    }

    static int res = 0;

    private static void dfs(int[] arr, int startIndex, LinkedList<Integer> list) {

        for (int i = startIndex; i < arr.length; i++) {
            if (list.isEmpty() || list.getLast() < arr[i]) {
                res++;
                list.addLast(arr[i]);
                dfs(arr, i + 1, list);
                list.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 3, 5, 7, 2};
        System.out.println(incrArrCount(arr));
        System.out.println(incrArrCountDp(arr));

        // jinhui
        nums = new int[]{4, 1, 6, 3, 5, 7, 2};

        len = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        backTracing(0, temp);
        System.out.println(ans);
    }

    static int ans;
    static int len;
    static int[] nums;

    public static void backTracing(int index, ArrayList<Integer> temp) {

        for (int i = index; i < len; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                ans = (ans + 1) % 1000000007;
                temp.add(nums[i]);
                backTracing(i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
