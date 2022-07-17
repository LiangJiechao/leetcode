package leetcode;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * @author xiaoliang
 * @date 2021/12/19 17:19
 **/
public class 剑指Offer56I_M_数组中数字出现的次数 {

    /**
     * 思路：利用异或，去除抑或后中出现的1，
     * 按这个1把数组分为两组，每一组再做一次异或，
     * 这两组异或出来的结果即为数组中出现奇数次的数
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        // 如果eor==0，则所有数都出现了偶数次
        if (eor == 0) {
            return new int[]{};
        }
        // eor!=0，取出最右边的1
        int rightOne = eor & (~eor + 1);

        int one = 0;
        int another = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) {
                one ^= num;
            } else {
                another ^= num;
            }
        }
        return new int[]{one, another};
    }

    public static void main(String[] args) {
        int[] arr ={1,2,5,2};
        System.out.println(singleNumbers(arr));
    }
}
