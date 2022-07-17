package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * @author xiaoliang
 * @date 2021/12/19 11:39
 **/
public class 剑指Offer07_M_重建二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路：递归，因为有前序遍历，所以直到某子树的根节点，中序遍历就可以划分左右子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int size = (int) (Math.ceil(inorder.length / 0.75) + 1);
        Map<Integer, Integer> map = new HashMap<>(size);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode buildTree(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj, Map<Integer, Integer> map) {

        if (prei > prej) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prei]);
        int index = map.get(preorder[prei]); // 划分的位置
        //
        root.left = buildTree(preorder, prei + 1, prei + 1 + (index - ini - 1),
                inorder, ini, index - 1,
                map);
        root.right = buildTree(preorder, prei + (index - ini) + 1, prej,
                inorder, index + 1, inj,
                map);
        return root;
    }

    public static void main(String[] args) {
        // String inOrder = "4251637";
        // String preOrder = "1245367"; // post=4526731
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
        System.out.println(111);

    }

}
