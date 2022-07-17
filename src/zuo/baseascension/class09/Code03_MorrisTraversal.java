package zuo.baseascension.class09;

/**
 * Morris遍历二叉树，利用叶子节点的空闲指针，就是线索二叉树的遍历，时间复杂度 O(n)，空间 O(1)
 * 类似于 线索二叉树
 * Morris遍历细节 假设来到当前节点cur，开始时cur来到头节点位置
 * 1）如果cur没有左孩子，cur向右移动(cur = cur.right)
 * 2）如果cur有左孩子，找到左子树上最右的节点mostRight：
 * a.如果mostRight的右指针指向空，让其指向cur， 然后cur向左移动(cur = cur.left)
 * b.如果mostRight的右指针指向cur，让其指向null， 然后cur向右移动(cur = cur.right)
 * 3）cur为空时遍历停止
 *
 * 总结：有左子树的节点，都会遍历两次，且知道目前是第几次遍历到该节点，可完成中序，先序
 * @author xiaoliang
 * @date 2021/09/20 09:54
 **/
public class Code03_MorrisTraversal {
}
