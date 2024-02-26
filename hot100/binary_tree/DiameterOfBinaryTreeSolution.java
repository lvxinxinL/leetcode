package hot100.binary_tree;

/**
 * 543. 二叉树的直径
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-26-10:00
 */

public class DiameterOfBinaryTreeSolution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    /**
     * 递归求深度，更新 ans（以某一节点为起点经过的最多节点数，直径则为 ans - 1）
     * @param node
     * @return
     */
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;// 遇到空节点，返回 0 
        }

        int L = depth(node.left);// 递归得左子树的深度
        int R = depth(node.right);// 递归得右子树的深度
        ans = Math.max(ans, L + R + 1);// L + R + 1 即为以 node 为七点经过节点数的最大值
        return Math.max(L, R) + 1;// 返回该节点为根的子树的深度
    }
}