package hot100.linked_list;

import java.util.HashSet;

/**
 * 160. 相交链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-04-11:24
 */
public class GetIntersectionNodeSolution {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 返回两个链表的相交节点，不存在返回 null
        HashSet<ListNode> hashSet = new HashSet<>();// 存储已经访问过的节点
        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }
        // 遍历 headB
        temp = headB;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
