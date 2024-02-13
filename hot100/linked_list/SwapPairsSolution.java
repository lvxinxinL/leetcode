package hot100.linked_list;

/**
 * 24. 两两交换链表中的节点
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-13-10:28
 */
public class SwapPairsSolution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
