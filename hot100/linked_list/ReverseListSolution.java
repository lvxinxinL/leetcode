package hot100.linked_list;

/**
 * 206. 反转链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-07-9:55
 */
public class ReverseListSolution {
    public static void main(String[] args) {}

    public static ListNode reverseList(ListNode head) {
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
}
