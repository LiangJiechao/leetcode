package zuo.middleascension.class13;

/**
 * 求一个树中从头到叶的最大权值
 * @author xiaoliang
 * @date 2021/09/25 11:26
 **/
public class Class13_树中从头到叶的最大权值 {


    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }


    public static int getMaxTravel(Node head){

        if (head==null){
            return 0;
        }
        int left = head.value;
        int right = head.value;
        
        if (head.left!=null){
            left += getMaxTravel(head.left);
        }
        if (head.right!=null){
            right += getMaxTravel(head.right);
        }
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(getMaxTravel(head));
    }

}
