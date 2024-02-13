package hot100.linked_list;

/**
 * 206. 反转链表
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-07-9:55
 */
public class ReverseListSolution {

    /**
     * 方法一：迭代法
     * @param head
     * @return
     */
    public static ListNode reverseList01(ListNode head) {
        ListNode newHead = null;// 新的头节点
        ListNode temp = null;
        while (head != null) {
            temp = head.next;// 记录下一个节点
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    /**
     * 方法二：递归法
     * @param head
     * @return
     */
    public ListNode reverseList02(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList02(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
}
