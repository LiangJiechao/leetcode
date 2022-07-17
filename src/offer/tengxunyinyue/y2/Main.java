package offer.tengxunyinyue.y2;

import java.util.*;

/**
 * 给定一棵树，这棵树是由编号的，然后给定一个数组链表，如[[2,4],[1,2]]
 * 然后[2,4]表示编号为2的节点的权值及其以下的子节点的权值都异或上 4，权值默认都为 0
 *
 * {1,2,3},[[2,4],[1,2]]
 * {2,6,2}
 *
 * {2,1,3,#,4},[[3,2],[1,4],[1,3],[4,2],[2,1]]
 * {1,6,3,#,4}
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

    public static TreeNode xorTree(TreeNode root, ArrayList<ArrayList<Integer>> op) {
        Map<Integer, TreeNode> map = new HashMap<>();
        getMap(root, map);

        for (ArrayList<Integer> item : op) {
            int key = item.get(0);
            int val = item.get(1);
            TreeNode curNode = map.get(key);
            dfs(curNode, val);
        }
        return root;

    }

    private static void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        root.val ^= val;
        dfs(root.left, val);
        dfs(root.right, val);

    }

    private static void getMap(TreeNode root, Map<Integer, TreeNode> map) {
        if (root == null) {
            return;
        }
        map.put(root.val, root);
        root.val = 0;
        getMap(root.left, map);
        getMap(root.right, map);
    }

    //{1,2,3},[[2,4],[1,2]]
    //{2,6,2}

    // {2,1,3,#,4},[[3,2],[1,4],[1,3],[4,2],[2,1]]
    // {1,6,3,#,4}

    public static void main(String[] args) {

        // {2,1,3,#,4},[[3,2],[1,4],[1,3],[4,2],[2,1]]
        // {1,6,3,#,4}

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(2);
        ArrayList<Integer> list5 = new ArrayList<>();
        list5.add(2);
        list5.add(1);

        op.add(list);
        op.add(list2);
        op.add(list3);
        op.add(list4);
        op.add(list5);
        System.out.println(xorTree(root, op));
    }

}
