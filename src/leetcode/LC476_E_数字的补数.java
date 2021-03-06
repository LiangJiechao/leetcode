package leetcode;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * @author xiaoliang
 * @date 2021/11/02 15:32
 **/
public class LC476_E_数字的补数 {

    public int findComplement(int num) {
        // Integer.highestOneBit 返回最左边的1 ==> 如 5：101 ==> 100
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(5));
        // lowestOneBit 最右边的1
        System.out.println(Integer.lowestOneBit(6));
    }

}
