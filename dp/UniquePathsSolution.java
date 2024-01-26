package dp;

/**
 * 62. 不同路径
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-25-11:49
 */
public class UniquePathsSolution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    /**
     1、dp[i][j]：到达 (i, j) 网格的不同路径数
     2、dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 到上方网格的路径数 + 到左侧网格的路径数
     3、dp[1][1] = 1; dp[1][j] = 1; dp[i][1] = 1;// 网格边界的到达路径是固定的，只能一直向下或向右
     4、从前到后遍历
     5、举例推导 dp 数组
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 初始化数组（网格边界的路径数）
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 到上方网格的路径数 + 到左侧网格的路径数
                System.out.println("dp[" + i + "]" + "dp[" + j + "] = " + dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
