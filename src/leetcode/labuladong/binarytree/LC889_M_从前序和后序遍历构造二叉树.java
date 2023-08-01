package leetcode.labuladong.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *  pre 和 post 遍历中的值是不同的正整数。
 * <p>
 * 示例：
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
 *
 * @author xiaoliang
 * @date 2022/01/18 21:44
 **/
public class LC889_M_从前序和后序遍历构造二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int[] preorder, int prei, int prej, int[] postorder, int posti, int postj, Map<Integer, Integer> map) {

        if (prei > prej) {
            return null;
        }
        if (prei == prej) {
            return new TreeNode(preorder[prei]);
        }

        TreeNode root = new TreeNode(preorder[prei]);
        // 假定左节点的头节点
        int leftRootVal = preorder[prei + 1];
        int index = map.get(leftRootVal);

        root.left = build(preorder, prei + 1, prei + 1 + index - posti,
                postorder, posti, index, map);
        root.right = build(preorder, prei + 1 + index - posti + 1, prej,
                postorder, index + 1, postj - 1, map);

        return root;
    }
}
