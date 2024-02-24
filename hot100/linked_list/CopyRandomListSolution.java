package hot100.linked_list;

import java.util.HashMap;

/**
 * 138. 随机链表的复制
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-24-10:57
 */
public class CopyRandomListSolution {
    /**
     * 方法一：绑定两个链表
     *
     * @param head
     * @return
     */
    public Node copyRandomList01(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        // 绑定新旧链表的节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));// key - 原节点，value - 新节点
            cur = cur.next;
        }

        cur = head;
        // 用旧链表的 next 和 random 域给新链表的 next 和 random 域赋值
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);// 新节点的 next
            map.get(cur).random = map.get(cur.random);// 新节点的 random
            cur = cur.next;
        }

        return map.get(head);// 返回原节点 head 对应的新节点
    }

    /**
     * 方法二：迭代赋值 + 拆分
     *
     * @param head
     * @return
     */
    public Node copyRandomList02(Node head) {
        if (head == null) {
            return null;
        }
        // 拷贝节点，用旧节点拷贝出一个新的 和旧节点值相同的 相连的 节点
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        // 新节点的随机节点的赋值
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        // 拆分节点，将新链表从旧链表中拆出来
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
