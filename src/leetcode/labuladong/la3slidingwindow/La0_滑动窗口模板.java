package leetcode.labuladong.la3slidingwindow;

/**
 * 先 left,right = 0 ，
 * while(right<nums.length){
 *     char c = nums[right];
 *     right++;
 *     加入窗口；
 *     window[c]++
 *
 *     判断是否要缩小窗口
 *     while(window[c]>1){
 *         left++;
 *     }
 *
 *     统计结果
 *     res = Math.max(res,right-left)
 * }
 * 三步走：右边无脑向右移，判断窗口是否收缩，统计结果
 * @author xiaoliang
 * @date 2022/03/18 22:16
 **/
public class La0_滑动窗口模板 {
}
