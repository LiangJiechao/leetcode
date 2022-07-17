package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 *
 * @author xiaoliang
 * @date 2021/12/08 10:11
 **/
public class 剑指Offer54_E_二叉搜索树的第k大节点 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * TODO 二叉搜索树的第k大节点
     * 思路2：中序遍历是有序的，然后先遍历得到有序序列，然后返回第k个
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(list.size() - k);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    /**
     * TODO 二叉搜索树的第k大节点
     * 思路3：中序遍历是有序的，然后先遍历得到有序序列，然后返回第k个，
     * 但其实不用遍历出整个序列，可以记录到第k个时，结束遍历，相当于剪枝
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest3(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder3(root, k);
        return ans3;
    }

    private int ans3 = 0, cnt3 = 0;

    private void inOrder3(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrder3(root.right, k);
        if (++cnt3 == k) {
            ans3 = root.val;
            return;
        }
        inOrder3(root.left, k);
    }

    /**
     * TODO 二叉搜索树的第k大节点
     * 思路：先向右子树搜，dfs递归
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    private int ans = 0, cnt = 0;

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        if (++cnt == k) {
            ans = root.val;
            return;
        }
        dfs(root.left, k);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        // 用steam() 去重，且会保存原来顺序
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        collect.stream().forEach(System.out::print); // 132
    }
}
