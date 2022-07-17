package leetcode.labuladong.la7singlelinklist;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * @author xiaoliang
 * @date 2022/01/09 21:36
 **/
public class La2_LC23_H_合并K个升序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 思路：使用小根堆
     * 把每个list的头先放入堆中
     * 弹出之后，又把该list的下一个结点放进堆中
     * 算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (o1, o2) -> {
            return o1.val - o2.val;
        });

        // 放入每个list的头
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!minHeap.isEmpty()) {
            ListNode poll = minHeap.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null) {
                minHeap.offer(poll.next);
            }
        }

        return dummy.next;
    }
}
