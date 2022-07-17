package leetcode.labuladong.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * @author xiaoliang
 * @date 2022/01/23 14:47
 **/
public class LC297_H_二叉树的序列化与反序列化 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    public class Codec {

        StringBuilder sb = new StringBuilder();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            flat(root);
            return sb.substring(0, sb.length() - 1);
        }

        private void flat(TreeNode root) {
            if (root == null) {
                sb.append("#,");
                return;
            }
            sb.append(root.val).append(",");
            flat(root.left);
            flat(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] split = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(split));
            return build(list);

        }

        private TreeNode build(LinkedList<String> list) {
            if (list.isEmpty()) {
                return null;
            }
            String val = list.removeFirst();
            if ("#".equals(val)){
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = build(list);
            root.right = build(list);
            return root;
        }
    }
}
