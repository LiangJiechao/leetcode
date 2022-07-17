package leetcode.labuladong.la15binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * preorder 和 inorder 均无重复元素
 *
 * @author xiaoliang
 * @date 2022/01/18 21:18
 **/
public class La5_LC105_M_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // preorder 和 inorder 均无重复元素
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);

    }

    private TreeNode build(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj, Map<Integer, Integer> map) {

        if (prei > prej) {
            return null;
        }
        Integer index = map.get(preorder[prei]);
        TreeNode root = new TreeNode(preorder[prei]);
        root.left = build(preorder, prei + 1, prei + index - ini,
                inorder, ini, inj - 1, map);
        root.right = build(preorder, prei + index - ini + 1, prej,
                inorder, index + 1, inj, map);
        return root;
    }
}
