package zuo.base.class04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 * 方法：
 * 用一种遍历方式遍历其树的数据顺序（包括空节点），如空节点用 #表示
 * @author xiaoliang
 * @date 2021/09/14 21:57
 **/

/**
 * 下面是Java中Queue的一些常用方法：
 *
 * add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
 *
 * offer       添加一个元素并返回true        如果队列已满，则返回false
 * poll         移除并返问队列头部的元素     如果队列为空，则返回null
 * peek       返回队列头部的元素              如果队列为空，则返回null
 *
 * put         添加一个元素                       如果队列满，则阻塞
 * take        移除并返回队列头部的元素
 */
public class Code10_SerializeAndReconstructTree {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 前序遍历将树序列化
     *
     * @param head
     * @return
     */
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        StringBuilder result = new StringBuilder();
        result.append(head.value).append("_");

        String left = serialByPre(head.left);
        String right = serialByPre(head.right);

        result.append(left).append(right);

        return result.toString();
    }

    public static Node reconByPreString(String preStr) {

        if (preStr == null || "".equals(preStr)) {
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        String[] arr = preStr.split("_");
        for (int i = 0; i < arr.length ; i++) {
            queue.offer(arr[i]);
        }
        Node head = recon(queue);

        return head;
    }

    private static Node recon(Queue<String> queue) {
        String value = queue.poll();
        if ("#".equals(value)) {
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = recon(queue);
        head.right = recon(queue);

        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = null;

        node4.left = null;
        node4.right = node5;

        String preStr = serialByPre(node1);
        System.out.println("preStr = " + preStr);

        Node node = reconByPreString(preStr);
        return ;
    }
}
