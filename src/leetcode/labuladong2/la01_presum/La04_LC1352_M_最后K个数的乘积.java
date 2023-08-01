package leetcode.labuladong2.la01_presum;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/product-of-the-last-k-numbers/
 *
 * @author liangjiechao
 * @date 2023/05/15 10:06
 **/
public class La04_LC1352_M_最后K个数的乘积 {

    class ProductOfNumbers {

        List<Integer> preproduct;

        public ProductOfNumbers() {
            preproduct = new ArrayList<>();
            preproduct.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                preproduct.clear();
                preproduct.add(1);
                return;
            }
            int size = preproduct.size();
            preproduct.add(preproduct.get(size - 1) * num);
        }

        public int getProduct(int k) {
            int size = preproduct.size();
            if (k > size - 1) {
                return 0;
            }
            return preproduct.get(size - 1) / preproduct.get(size - 1 - k);
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

}
