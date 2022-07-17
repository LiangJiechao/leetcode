package offer.huawei.h3;

import java.util.*;

/**
 * 
 * @author xiaoliang
 * @date 2022/03/30 18:57
 **/
public class Main {

    static class TreeNode{
        String value;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(value).append(",");
            if (left!=null){
                sb.append(left.toString());
            }else {
                sb.append("null").append(",");
            }
            if (right!=null){
                sb.append(right.toString());
            }else {
                sb.append("null").append(",");
            }
            return sb.toString();
            // [2,1,null]
        }
    }
    /**
     * [1,2,3,1,null,2,null,null,null,null,null,1,null,null,null]
     * [2,1,null]
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String substring = s.substring(1, s.length() - 1);

        String[] split = substring.split(",");
        ArrayList<String> list = new ArrayList<>();
        for(String item : split){
            list.add(item);
        }

        TreeNode root = buildTree(list,0);
        process(root);


        if (res.size()==0){
            System.out.println("-1");
        }else {

            TreeNode treeNode = res.get(res.size() - 1);
            String sss = print(treeNode);
            System.out.println(sss);
//            ArrayList<String> stringArrayList = new ArrayList<>();
//            for (TreeNode tree : res) {
//                stringArrayList.add(tree.toString());
//            }
//            String s1 = stringArrayList.stream().max((i1, i2) -> i2.length() - i2.length()).get();
//            String[] split1 = s1.split(",");
//            StringBuilder sout = new StringBuilder();
//            sout.append("[");
//            int index = 0;
//            for (String s2 : split1) {
//                if (s2.equals("null")){
//
//                }
//            }
//            sout.append("]");
//            System.out.println(sout);
        }


    }

    private static String print(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll==null){
                sb.append("null").append(",");
                continue;
            }else {
                sb.append(poll.value).append(",");
            }
            if (poll.left!=null){
                queue.offer(poll.left);

                queue.offer(poll.right);

            }

        }
        return "["+sb.toString().substring(0,sb.length()-1)+"]";
    }

    static List<TreeNode> res = new ArrayList<>();
    static Map<String,Integer> map = new HashMap<>();
    private static String process(TreeNode root){
        if (root==null){
            return "#";
        }
        String left = process(root.left);
        String right = process(root.right);

        String subList = root.value+left+right;

        if (subList.length()>3){
            Integer count = map.getOrDefault(subList, 0);
            if (count ==1){
                res.add(root);
            }
             map.put(subList,count+1);
        }
        return subList;
    }

    private static TreeNode buildTree(ArrayList<String> list,int n) {
        if (n>=list.size() || list.get(n).equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(list.get(n));
        root.left = buildTree(list,2*(n+1)-1);
        root.right = buildTree(list,2*(n+1));
        return root;
    }


}
