package offer.bw.b1;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {
    public static void main(String[] args) {
        Problem01 problem01 = new Problem01();
        int[][] arrs = new int[][]{
                {1, 3, 4, 6, 7, 8, 9, 10},
                {2, 4, 6, 8, 10},
                {5, 6, 7, 8, 9, 11, 12, 13, 14},
                {3, 6, 9, 12, 13, 14}
        };
        int[] ans = problem01.andMerger(arrs);
        for (int n : ans) {
            System.out.print(n + "\t");
        }
    }

    public int[] andMerger(int[][] arrs) {
        int len = arrs.length;
        if (len == 0) return new int[]{};
        if (len == 1) return arrs[0];
        return merge(arrs, 0, len - 1);
    }

    public int[] merge(int[][] arrs, int left, int right) {
        if (left >= right) return arrs[left];
        int mid = left + (right - left) / 2;
        int[] a = merge(arrs, left, mid);
        int[] b = merge(arrs, mid + 1, right);
        return mergeTwo(a, b);
    }

    public int[] mergeTwo(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        if (len1 == 0 || len2 == 0) return new int[]{};
        int p1 = 0;
        int p2 = 0;
        List<Integer> nums = new ArrayList();
        while (p1 < len1 && p2 < len2) {
            int n1 = a[p1];
            int n2 = b[p2];
            if (n1 == n2) {
                nums.add(n1);
                p1++;
                p2++;
            } else if (n1 < n2) {
                p1++;
            } else {
                p2++;
            }
        }
        int size = nums.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = nums.get(i);
        }
        return ans;
    }
}
