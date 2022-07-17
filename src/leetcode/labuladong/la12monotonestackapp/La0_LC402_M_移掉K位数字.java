package leetcode.labuladong.la12monotonestackapp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 * <p>
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * <p>
 * 输入：num = "10200", k = 1
 * 输出："200"
 * <p>
 * 除了 0 本身之外，num 不含任何前导零
 *
 * @author xiaoliang
 * @date 2022/02/28 09:07
 **/
public class La0_LC402_M_移掉K位数字 {

    /**
     * 单调栈应用
     * 思路：返回这个最小的数字。
     * 因为 12a34与 12b34比较。如果a>b则  12a34 > 12b34
     * 所以我们选择的数比其前一个数小的数
     * 如果选完后k还大于0；则删除后k个数
     *
     * 先把逆序的数去掉，越在前面的逆序数，越要去掉
     * 54321 (k==2)--> 321
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Deque<Character> stack = new LinkedList<>();

        // 最后结果的长度
        int remain = num.length() - k;

        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }

//        while (k>0){
//            stack.pop();
//            k--;
//        }
//        if (stack.isEmpty()){
//            return "0";
//        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        StringBuilder res = new StringBuilder();
        boolean resEmpty = true;
        for (char c : sb.substring(0,remain).toCharArray()) {
            if (resEmpty && c == '0') {
                continue;
            }
            resEmpty = false;
            res.append(c);
        }
        return resEmpty ? "0" : res.toString();
    }

}
