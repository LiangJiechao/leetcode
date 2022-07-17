package leetcode.labuladong.la1presum;

/**
 * 这个技巧在⽣活中运⽤也挺⼴泛的，⽐⽅说，你们班上有若⼲同学，每个同学有⼀个期末考试的成绩（满分100 分），
 * 那么请你实现⼀个 API，输⼊任意⼀个分数段，返回有多少同学的成绩在这个分数段内。
 *
 * @author xiaoliang
 * @date 2022/02/23 15:10
 **/
public class LC303_E_区域和检索_学生成绩分数段 {

    /**
     * 思路：构造前缀和
     */
    static class StudentScore {
        // 前缀和
        // presum[2]代表前两个数的和
        private int[] presum;

        public StudentScore(int[] scores) {
            presum = new int[100 + 1];
            for (int i = 0; i < scores.length; i++) {
                presum[scores[i]]++;
            }
            // presum[0] = 0;
            for (int i = 1; i < presum.length; i++) {
                presum[i] = presum[i] + presum[i - 1];
            }
        }

        public int sumRange(int fromScore, int toScore) {
            return presum[toScore] - presum[fromScore - 1];
        }
    }

    public static void main(String[] args) {
        int[] scores = {0, 0, 1, 2, 3, 4, 22, 11, 55, 33, 22, 11, 32, 13};
        StudentScore obj = new StudentScore(scores);
        System.out.println(obj.sumRange(1, 2));
        System.out.println(obj.sumRange(1, 55));// 12
        System.out.println(obj.sumRange(5, 60));

    }

}
