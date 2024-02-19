package hot100.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-19-11:01
 */
public class MaxDepthSolution {
    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // 广度优先搜索：一层一层拓展，二叉树的最大深度就是二叉树的层数
        int maxDepth = 0;// 存储最大深度
        if (root == null) {
            return maxDepth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {// 这一层还有节点
                TreeNode node = queue.poll();// 遍历该节点的下一层
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    private int maxDep = 0;
    public int maxDepth02(TreeNode root) {
        // 深度优先搜索：左右子树的最远节点处就是二叉树的最大深度
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth02(root.left),maxDepth02(root.right));
    }
}

