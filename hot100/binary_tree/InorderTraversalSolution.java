package hot100.binary_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-19-10:12
 */
public class InorderTraversalSolution {
    List<Integer> resList = new ArrayList<>();// 存储中序遍历结果

    /**
     * 方法一：递归法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal01(TreeNode root) {
        inOrder01(root);
        return resList;
    }

    // 中序遍历：左中右
    public void inOrder01(TreeNode root) {
        if (root == null) return;
        inorderTraversal01(root.left);
        resList.add(root.val);
        inorderTraversal01(root.right);
    }

    /**
     * 方法二：迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal02(TreeNode root) {
        // 迭代法
        List<Integer> resList = new ArrayList<>();// 存储中序遍历结果
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        if (root == null) return new ArrayList<Integer>();
        while(!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;// 找最右边的
            } else {
                cur = st.pop();
                resList.add(cur.val);
                cur = cur.right;
            }
        }
        return resList;
    }
}
