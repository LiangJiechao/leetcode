package leetcode.labuladong.la2differarray;

/**
 * 长度为n的数组，初始情况下所有的数组均为0，你将会被给出k个更新的操作
 * 每个操作为一个三元组：[startIndex,endIndex,inc]
 *
 * @author xiaoliang
 * @date 2022/02/23 21:10
 **/
public class LC370_M_区间加法 {

    int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        //构造差分解法
        DifferArray df = new DifferArray(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i,j,val);
        }
        return df.result();
    }

}
