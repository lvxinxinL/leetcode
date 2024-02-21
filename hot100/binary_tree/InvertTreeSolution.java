package hot100.binary_tree;

/**
 * 226. 翻转二叉树
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-21-8:46
 */
public class InvertTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
