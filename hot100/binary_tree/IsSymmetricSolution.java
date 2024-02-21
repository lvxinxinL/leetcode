package hot100.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-21-9:18
 */
public class IsSymmetricSolution {

    /**
     * 方法一：递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetric01(TreeNode root) {
        return dfs(root.left, root.right);
    }

    /**
     * 方法二：迭代法
     * 递归转迭代经常用 队列 来实现
     *
     * @param root
     * @return
     */
    public boolean isSymmetric02(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 每次从队列中取出两个进行比较
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            // 将节点按顺序塞入队列
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        // 递归比较左右子树
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
