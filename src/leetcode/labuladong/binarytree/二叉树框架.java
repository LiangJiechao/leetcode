package leetcode.labuladong.binarytree;

/**
 * 写树相关的算法，简单说就是，先搞清楚当前 root 节点「该做什么」以及「什么时候做」，然后根据函数
 * 定义递归调⽤⼦节点，递归调⽤会让孩⼦节点做相同的事情。
 * 所谓「该做什么」就是让你想清楚写什么代码能够实现题⽬想要的效果，所谓「什么时候做」，就是让你思
 * 考这段代码到底应该写在前序、中序还是后序遍历的代码位置上。
 *
 * @author xiaoliang
 * @date 2022/01/16 11:01
 **/
public class 二叉树框架 {

    /*
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }
    */
    // 两种解题思路
    // 二叉树题目的递归解法可以分两类思路，
    // 第一类是遍历一遍二叉树得出答案，
    // 第二类是通过分解问题计算出答案，
    // 这两类思路分别对应着 回溯算法核心框架 和 动态规划核心框架。

    /*
    /* 迭代遍历数组
    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    /* 递归遍历数组
    void traverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        // 前序位置
        traverse(arr, i + 1);
        // 后序位置
    }

    /* 迭代遍历单链表
    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {

        }
    }

    /* 递归遍历单链表
    void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        // 前序位置
        traverse(head.next);
        // 后序位置
    }
    */
}
