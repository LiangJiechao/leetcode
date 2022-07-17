package leetcode.labuladong.la31lca;

/**
 * 这次输入的二叉树节点比较特殊，包含指向父节点的指针：
 * @author xiaoliang
 * @date 2022/04/23 17:25
 **/
public class La5_LC1650_M_二叉树的最近公共祖先III {

    public class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q){
        Node a = p;
        Node b = q;

        while (a!=b){
            if (a==null){
                a = q;
            }else {
                a = a.parent;
            }

            if (b==null){
                b = p;
            }else {
                b = b.parent;
            }
        }

        return a ;
    }
}
