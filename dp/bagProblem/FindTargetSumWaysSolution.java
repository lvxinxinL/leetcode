package dp.bagProblem;

import java.util.Arrays;

/**
 * 494. 目标和
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-03-10:44
 */
public class FindTargetSumWaysSolution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1,};
        int targetSumWays = findTargetSumWays(nums, 3);
        System.out.println(targetSumWays);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum) return 0;// target 过大，没有方法能构造目标和
        if ((sum + target) % 2 == 1) return 0;// 2x = sum + target，奇数不行

        int x = (target + sum) / 2;// target = x - (sum - x); 和 - 差 = target
        int[] dp = new int[x + 1];// dp[j] 表示装满容量为 j 的背包有 dp[j] 种方法
        dp[0] = 1;// 初始化
        for (int i = 0; i < len; i++) {
            for (int j = x; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[x];
    }
}
