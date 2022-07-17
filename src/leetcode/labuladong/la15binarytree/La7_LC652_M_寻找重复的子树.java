package leetcode.labuladong.la15binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 * @author xiaoliang
 * @date 2022/01/23 14:20
 **/
public class La7_LC652_M_寻找重复的子树 {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    /**
     * 思路：变成⽐如字符串这样的类型，然后利⽤ HashSet
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {

        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        Integer freq = map.getOrDefault(subTree, 0);
        if (freq == 1) {
            res.add(root);
        }
        map.put(subTree, freq + 1);
        return subTree;
    }

}
