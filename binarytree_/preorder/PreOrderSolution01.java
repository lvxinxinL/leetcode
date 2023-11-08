package binarytree_.preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历(迭代法)：中左右
 * @author Ghost
 * @version 1.0
 */
public class PreOrderSolution01 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(6), new TreeNode(9)), new TreeNode(5));
        PreOrderSolution01 preOrderSolution01 = new PreOrderSolution01();
        List<Integer> integers = preOrderSolution01.preorderTraversal(root);
        System.out.println(integers);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {// 只要栈非空就循环执行里面的逻辑
            // 弹出栈顶元素
            TreeNode node = st.pop();
            result.add(node.val);// 将弹出的元素(栈顶元素)保存到result
            if (node.right != null) {
                // 右子节点非空，压入栈中=>栈是先进后出的数据结构，先压右子节点right，后出right
                st.push(node.right);
            }
            if (node.left != null) {
                // 左子结点非空压入栈中，空的话就不压入
                st.push(node.left);
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

