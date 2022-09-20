package offer.xiaomi.x20220914.x1;

import java.util.Scanner;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class Solution {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {

        if (left==1){
            return reverse(head,right);
        }else {
            head.next = reverseBetween(head.next,left-1,right-1);
            return head;
        }

    }

    private ListNode<Integer> reverse(ListNode<Integer> head, int right) {
        ListNode<Integer> a = head;
        for (int i = 1; i < right; i++) {
            a = a.next;
        }
        ListNode<Integer> node = reverse2(head, a);
//        head.next = a.next;
        return node;
    }
    ListNode<Integer> successor = null;
    private ListNode<Integer> reverse2(ListNode<Integer> head, ListNode<Integer> a) {
        if (head==a){
            successor = head.next;
            return head;
        }
        ListNode<Integer> last = reverse2(head.next,a);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new Solution().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}

