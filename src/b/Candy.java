package b;

import java.util.Arrays;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1：
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * <p>
 * 链接：https://leetcode-cn.com/problems/candy
 * @date 2021/6/26 17:01
 */
// todo 还没解出
public class Candy {

    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        //初始化
        Arrays.fill(result, 1);
        //从左往右
        for (int i = 0; i < result.length - 1; i++) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = result[i + 1] + 1;
            }
        }
        //从右往左
        for (int i = result.length - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = Math.max(result[i - 1] + 1, result[i]);
            }
        }
        int sum = 0;
        for (int item : result) {
            sum += item;
        }

        return sum;
    }
}
