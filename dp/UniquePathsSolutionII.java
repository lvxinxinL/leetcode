package dp;

/**
 * 63. 不同路径Ⅱ （网格中有障碍物）
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-26-13:02
 */
public class UniquePathsSolutionII {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePaths(arr));
    }

    /**
     1、dp[i][j]：到达 (i, j) 网格的不同路径数
     2、dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 到上方网格的路径数 + 到左侧网格的路径数
     3、初始化：dp[0][0] = 1; dp[0][j] = 1; dp[i][0] = 1;// 网格边界的到达路径是固定的，只能一直向下或向右，碰到障碍物之后后面的都不可达了！！！
     4、从前到后遍历
     5、举例推导 dp 数组
     */
    public static int uniquePaths(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            // start 或 finish 是障碍物，不可达
            return 0;
        }
        // 初始化数组
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {// 如果碰到障碍物直接中断，后面的都是 0（不可达）
            dp[0][i] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {// 障碍物的地方，到达路径数 = 0
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
