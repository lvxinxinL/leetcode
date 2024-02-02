package dp.bagProblem;

/**
 * 01 背包问题基础
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-28-19:38
 */
public class BagProblem01 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    /**
     * 1. dp[i][j]：放入 0 - i 个物品，容量为 j 的背包能取得的最大价值
     * 2. 递推方程：dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - weight[i]] + value[i]));
     * 3. 初始化：if (j >= weight[0]) dp[0][j] = value[0];// 容量比第一个物品重量大的背包在只有物品 0 时价值就是 value[0]
     *    dp[i][0] = 0;// 容量为 0 的背包价值为 0
     * 4. 从前向后遍历
     * 5. 举例推导 dp 数组
     */

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int[][] dp = new int[weight.length + 1][bagSize + 1];
        // 初始化
        for (int i = weight[0]; i <= bagSize; i++) {
            // 背包容量大于物品重量时
            dp[0][i] = value[0];
        }

        // 遍历物品和背包容量
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i-1][j];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

         // 打印 dp 数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
