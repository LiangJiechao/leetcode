package leetcode.labuladong.la5tianjisaima;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 田忌赛马：打得过就打，打不过就拿⾃⼰的垃圾和对⽅的精锐互换
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * <p>
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 *
 * @author xiaoliang
 * @date 2022/02/24 21:47
 **/
public class LC870_M_优势洗牌 {

    /**
     * 整体思路：先将num1和nums2排序，然后看看1的最大能不能和2的打，打不过就用最小的代替
     * 但nums2不可改，所以用堆来存储关系，同时排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });
        for (int i = 0; i < nums2.length; i++) {
            maxHeap.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] res = new int[nums1.length];
        int left = 0, right = nums1.length - 1;
        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.poll();

            if (nums1[right] > poll[1]) {
                // 自己能打过
                res[poll[0]] = nums1[right];
                right--;
            } else {
                // 打不过，用最小的代替
                res[poll[0]] = nums1[left];
                left++;
            }
        }
        return res;

    }
}
