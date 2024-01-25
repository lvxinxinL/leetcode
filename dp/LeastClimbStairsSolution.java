package dp;

/**
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-25-11:11
 */
public class LeastClimbStairsSolution {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int result = minCostClimbingStairs(cost);
        System.out.println("result = " + result);
    }

    /**
     1、dp[i]：到达第 i 个台阶所需要的最低花费，顶部是指越过第 n 阶
     2、dp[i] = min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
     3、dp[0] = 0; dp[1] = 0;
     4、从前到后遍历
     5、举例推导 dp 数组
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            System.out.println(dp[i]);
        }
        return dp[n];
    }
}
