package offer.tengxunyinyue.y1;

import java.util.*;

/**
 * 给定一棵树，然后给定一个数组[2,4]，表示删除层数为2和4，求剩下的树列表
 * 如
 *           1
 *         /   \
 *        2     3
 *       /     /
 *      4     5
 *       \   /
 *        6 7
 *  删除第3层后
 *           1
 *         /   \
 *        2     3
 *
 *        6   7
 * 剩下 [1,6,7]节点
 * @author xiaoliang
 * @date 2022/04/27 18:58
 **/
public class Main {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);

        ArrayList<TreeNode> treeNodes = deleteLevel(root, list);
        System.out.println(treeNodes);
    }


    public static ArrayList<TreeNode> deleteLevel(TreeNode root, ArrayList<Integer> arr) {
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        int deep = getMapAndDeep(root, map);


        for (Integer delDeep : arr) {
            if (map.containsKey(delDeep-1)){
                List<TreeNode> parentNodes = map.get(delDeep - 1);
                parentNodes.forEach(item->{
                    item.left=null;
                    item.right=null;
                });
            }
            map.remove(delDeep);
        }

        ArrayList<TreeNode> res = new ArrayList<>();
        for (int i = 1 ; i <=deep; i++) {
            if (!map.containsKey(i-1) && map.containsKey(i)){
                res.addAll(map.get(i));
            }
        }
        return res;
    }

    private static int getMapAndDeep(TreeNode root, Map<Integer, List<TreeNode>> map) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int deep = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.pollFirst();
                List<TreeNode> deepList = map.getOrDefault(deep, new ArrayList<>());
                deepList.add(poll);
                map.put(deep,deepList);
                if (poll.left != null) {
                    queue.offerLast(poll.left);
                }
                if (poll.right != null) {
                    queue.offerLast(poll.right);
                }
            }

            deep++;
        }
        return deep-1;
    }
}
