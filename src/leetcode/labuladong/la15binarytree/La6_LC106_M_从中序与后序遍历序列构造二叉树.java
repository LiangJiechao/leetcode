package leetcode.labuladong.la15binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author xiaoliang
 * @date 2022/01/18 21:34
 **/
public class La6_LC106_M_从中序与后序遍历序列构造二叉树 {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // preorder 和 inorder 均无重复元素
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    private TreeNode build(int[] postorder, int posti, int postj, int[] inorder, int ini, int inj, Map<Integer, Integer> map) {
        if (posti > postj) {
            return null;
        }
        int index = map.get(postorder[postj]);
        TreeNode root = new TreeNode(postorder[postj]);
        root.left = build(postorder, posti, posti + index - ini - 1,
                inorder, ini, index - 1, map);
        root.right = build(postorder, posti + index - ini, postj - 1,
                inorder, index + 1, inj, map);
        return root;
    }
}
