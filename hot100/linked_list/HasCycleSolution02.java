package hot100.linked_list;

import java.util.HashMap;

/**
 * 142. 环形链表II
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-08-9:50
 */
public class HasCycleSolution02 {
    /**
     * 方法一：使用 HashMap 存储已访问 ListNode
     * @param head
     * @return
     */
    public ListNode detectCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode tempNode = head;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (tempNode != null) {
            if (hashMap.containsKey(tempNode)) {
                return tempNode;
            }
            hashMap.put(tempNode, tempNode.val);
            tempNode = tempNode.next;

        }
        return null;
    }

    /**
     * 方法二：快慢指针法 todo
     * @param head
     * @return
     */
    public ListNode hasCycle02(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        return null;
    }
}
