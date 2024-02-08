package hot100.linked_list;

/**
 * 21. 合并两个有序链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-08-10:50
 */
public class MergeTwoListsSolution {
    /**
     * 迭代法合并两个升序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);// 新的链表
        ListNode prev = prehead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        // 将剩下的链表接到后面
        prev.next = list1 == null ? list2 :list1;
        return prehead.next;
    }
}
