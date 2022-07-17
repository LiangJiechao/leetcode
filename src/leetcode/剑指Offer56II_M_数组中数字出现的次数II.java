package leetcode;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * @author xiaoliang
 * @date 2021/12/19 17:33
 **/
public class 剑指Offer56II_M_数组中数字出现的次数II {

    /**
     * 书上解法： 如果一个数字出现3次，它的二进制每一位也出现的3次。
     * 如果把所有的出现三次的数字的二进制表示的每一位都分别加起来，那么每一位都能被3整除。
     * 我们把数组中所有的数字的二进制表示的每一位都加起来。
     * 如果某一位能被3整除，那么这一位对只出现一次的那个数的这一肯定为0。
     * 如果某一位不能被3整除，那么只出现一次的那个数字的该位置一定为1.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] help = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                help[i] += ((num >> i) & 1) == 1 ? 1 : 0;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= help[i] % 3;
        }
        return res;
    }
}
