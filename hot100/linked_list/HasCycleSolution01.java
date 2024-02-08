package hot100.linked_list;

import java.util.HashMap;

/**
 * 141. 环形链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-08-9:50
 */
public class HasCycleSolution01 {
    /**
     * 方法一：使用 HashMap 存储已访问 ListNode
     * @param head
     * @return
     */
    public boolean hasCycle01(ListNode head) {
        // 使用 HashMap 存储已访问的节点，判断链表中是否存在环，即判断 node.next 是否已存在
        if (head == null || head.next == null) return false;
        ListNode tempNode = head;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (tempNode != null) {
            if (hashMap.containsKey(tempNode)) {
                return true;
            } else {
                hashMap.put(tempNode, tempNode.val);
                tempNode = tempNode.next;
            }
        }
        return false;
    }

    /**
     * 方法二：快慢指针法
     * @param head
     * @return
     */
    public boolean hasCycle02(ListNode head) {
        // 使用快慢指针，快指针如果追上慢指针说明存在环
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        // slow 和 fast 初始化为 head 和 head.next 的原因：while 循环，循环条件先行，如果都初始化为 head 无法进入循环体
        // 想象在 head 前面还有一个虚拟节点，slow 从虚拟节点跳一步到 head，fast 从虚拟节点跳两步到 head.next
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;// 快指针到达链表末尾
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;// slow == fast; 快指针追上慢指针
    }
}
