package dp;

/**
 * 02 背包问题基础——滚动数组
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-01-9:35
 */
public class BagProblem02 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    /**
     * 1. dp[j]：容量为 j 的背包能取得的最大价值
     * 2. 递推方程：dp[j] = Math.max(dp[j], (dp[j - weight[i]] + value[i]));
     * 3. 初始化：dp[i] = 0;// 容量比第一个物品重量大的背包在只有物品 0 时价值就是 value[0]
     * 4. 先遍历物品再遍历背包（不能颠倒）遍历背包时逆序遍历
     * 5. 举例推导 dp 数组
     */

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize + 1];
        // 遍历物品和背包容量
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], (dp[j - weight[i]] + value[i]));
            }
        }

         // 打印 dp 数组
        for (int j = 0; j <= bagSize; j++){
            System.out.print(dp[j] + " ");
        }
    }
}
