package hot100.linked_list;

/**
 * 2. 两数相加
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-12-10:28
 */
public class AddTwoNumbersSolution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 遍历两个链表，将各节点的值相加，满 10 进 1，高位的接到后面
        ListNode head = null;
        ListNode tail = null;
        int flag = 0;// 记录进位 1
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + flag;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            flag = sum / 10;// 满 10 为 1，不满 10 为 0
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag > 0) {// 还有进位，添加新节点
            tail.next = new ListNode(flag);
        }
        return head;
    }
}
