package dp.bagProblem;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-02-10:06
 */
public class LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int result = lastStoneWeightII(stones);
        System.out.println(result);
    }
    public static int lastStoneWeightII(int[] stones) {
        // 把石头分成重量最相近两堆，两堆相撞，剩下的重量最小
        int len = stones.length;
        if (len == 1) {
            return stones[0];
        }
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;// 向下取整
        // 转化为求背包容量 target 最多能装下的物品的价值
        // 先遍历物品，再遍历背包，背包逆序遍历
        int[] dp = new int[target + 1];// dp[j] 表示容量为 j 的背包能装下物品的最大价值
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        int remain = (sum - dp[target]) - dp[target];// 剩余的石头重量
        return remain;
    }
}
