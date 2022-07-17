package leetcode;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * @author xiaoliang
 * @date 2021/12/19 10:41
 **/
public class 剑指Offer33_M_二叉搜索树的后序遍历序列 {

    /**
     * 思路：用递归，应该根节点在最后面，然后其左子树在最前面开始数，且小于根节点，剩下的为右子树
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 2) {
            return true;
        }
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        // root node
        int root = postorder[right];
        int mid = left;
        // 找到左子树分界
        while (mid < right && postorder[mid] < root) {
            mid++;
        }

        // 若右子树中有比root小的，直接 return false
        for (int i = mid; i < right; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        // 这里边界要注意
        if (!verifyPostorder(postorder, left, mid - 1)) {
            return false;
        }
        if (!verifyPostorder(postorder, mid, right - 1)) {
            return false;
        }
        return true;
    }

}
