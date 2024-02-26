package hot100.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-26-10:21
 */
public class LevelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 层序遍历：从上到下，从左到右逐个访问=>先进先出=>队列
        // 问题：如何确定每一层的节点数？
        List<List<Integer>> resList = new ArrayList<>();// 存储结果集，List<Integer> 代表一层的节点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) {
            return resList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {// 还有节点
            List<Integer> list = new ArrayList<>();// 存储一层节点的 val
            int size = queue.size();
            while (size-- > 0) {// 一层
                TreeNode tmpNode = queue.poll();
                list.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
            resList.add(list);// 将一层的节点加入结果集
        }
        return resList;
    }
}