package offer.tengxun.t4;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：AFU(OvO)
 * 链接：https://www.nowcoder.com/discuss/940915?type=post&order=create&pos=&page=1&ncTraceId=&channel=-1&source_id=search_post_nctrack&gio_id=24B388B3E038C6EC048F97CF747D6AA7-1650937823795
 * 来源：牛客网
 * <p>
 * 给一个链表数组，数组中的每个链表是一个循环链表中的破碎的部分，
 * 且每个链表结点的值唯一且为数值类型，求将这个循环链表复原以后，
 * 从链表中任意一个结点正序或逆序遍历 字典序 最小的那个链表，并返回。
 * 思路：链表中结点的值唯一，使用字典记录结点的前驱和后继，并记录最小值，然后从最小值开始遍历，
 * 并判断最小值的前驱和后继哪个更小，从更小的开始顺序遍历。
 * 题目：链表环最小字典序
 *
 * 输入:
 * [{3,7,4},{7,4,5,1,10,3}]
 * 输出:
 * {1,5,4,7,3,10}
 *
 * @author xiaoliang
 * @date 2022/04/24 19:56
 **/
public class Main {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode solve(ListNode[] arr) {
        // write code here
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        Map<Integer, Integer> preMap = new HashMap<>();
        Map<Integer, Integer> nextMap = new HashMap<>();
        Map<Integer, Boolean> visitedMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ListNode curNode = arr[i];
            while (curNode != null) {
                nodeMap.put(curNode.val, curNode);
                visitedMap.put(curNode.val,false);
                if (curNode.next != null) {
                    preMap.put(curNode.next.val, curNode.val);
                    nextMap.put(curNode.val, curNode.next.val);
                }
                min = Math.min(min, curNode.val);
                curNode = curNode.next;
            }
        }

        visitedMap.put(min, true);
        ListNode head = new ListNode(min);
        ListNode p = head;
        if (preMap.get(min) < nextMap.get(min)) {
            ListNode node = nodeMap.get(preMap.get(min));
            while (!visitedMap.get(node.val)) {
                visitedMap.put(node.val, true);
                p.next = node;
                p = p.next;
                node = nodeMap.get(preMap.get(node.val));
            }
            p.next = null;

        } else {
            ListNode node = nodeMap.get(nextMap.get(min));
            while (!visitedMap.get(node.val)) {
                visitedMap.put(node.val, true);
                p.next = node;
                p = p.next;
                node = nodeMap.get(nextMap.get(node.val));
            }
            p.next = null;
        }

        printList(head);
        return head;
    }

    private static void printList(ListNode head) {
        System.out.print("链表->{");
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
        a.next.next = new ListNode(4);

        ListNode b = new ListNode(7);
        b.next = new ListNode(4);
        b.next.next = new ListNode(5);
        b.next.next.next = new ListNode(1);
        b.next.next.next.next = new ListNode(10);
        b.next.next.next.next.next = new ListNode(3);

        ListNode[] arr = {a,b};
        solve(arr);
    }
}
