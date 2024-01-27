package dp;

/**
 * 96. 不同的二叉搜索树
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-27-11:36
 */
public class NumTressSolution {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    /**
     1. dp[i]：从 1 到 i 的节点组成的不同二叉搜索树的种数
     2. dp[i] += dp[j - 1] * dp[i - j];// 左子树 * 右子树；根节点从 1 到 i
     3. 初始化：dp[0] = 1;// 左边没有节点也要乘 1 dp[1] = 1;
     4. 从前往后遍历
     5. 举例推导 dp 数组
     */
    public static int numTrees(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];// 左子树 * 右子树
            }
        }
        return dp[n];
    }
}
