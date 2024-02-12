package hot100.linked_list;

/**
 * 19. 删除链表的倒数第 N 个节点
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-12-10:30
 */
public class RemoveNthFromEndSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {// 只有一个节点
            return null;
        }

        // 删除节点就是直接让前一个节点的 next 跳过该节点，直接指向下一个节点
        // 单链表怎么找到倒数第 N 个？
        // 遍历链表，记录链表节点数量
        int count = 0;
        ListNode dummy = new ListNode(0, head);
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        // 走到要删除的位置
        ListNode cur = dummy;
        for(int i = 1; i < count - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;// 执行删除操作
        return dummy.next;// 不能返回 head，可能头节点已经被删了，现在的头节点就是哑节点的 next！
    }
}
