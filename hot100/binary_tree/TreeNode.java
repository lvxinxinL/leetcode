package hot100.binary_tree;

/**
 * Definition for a binary tree node.
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-19-10:13
 */

public class TreeNode {
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
