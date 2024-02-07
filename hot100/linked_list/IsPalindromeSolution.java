package hot100.linked_list;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-07-10:23
 */
public class IsPalindromeSolution {
    public static void main(String[] args) {}

    public static boolean isPalindrome1(ListNode head) {
        // 方法一：将链表的值复制到数组中 O(n)，用双指针法判断数组列表是否是回文串
        if (head.next == null) {
            return true;
        }
        // 1. 复制
        List<Integer> list = new ArrayList<>();
        ListNode currentNode = head;// 不能直接对 head 操作，会改变原链表的结构！
        while (currentNode != null) {
            list.add(currentNode.val);
            currentNode = currentNode.next;
        }
        // 2. 双指针法判断数组列表是否是回文数组
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
