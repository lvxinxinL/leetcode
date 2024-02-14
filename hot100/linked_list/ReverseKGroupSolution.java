package hot100.linked_list;

/**
 * 25. K 个一组翻转链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-14-10:34
 */
public class ReverseKGroupSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //
        ListNode dummy = new ListNode(0, head);
        ListNode preNode = dummy;
        ListNode nextNode = null;

        while (head != null) {
            ListNode tail = preNode;
            // 判断后面是否还有 k 个节点
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;// 反转结束，返回新链表的头节点
                }
            }
            nextNode = tail.next;
            // 反转链表
            ListNode[] childrenList = reverseList(head, tail);
            head = childrenList[0];
            tail = childrenList[1];
            // 连接子链表
            preNode.next = head;
            tail.next = nextNode;
            preNode = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    // 反转链表
    private ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode newHead = tail.next;
        ListNode cur = null;
        ListNode p = head;
        while (newHead != tail) {
            cur = p.next;
            p.next = newHead;
            newHead = p;
            p = cur;
        }
        return new ListNode[]{tail, head};
    }
}
