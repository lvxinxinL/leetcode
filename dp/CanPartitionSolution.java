package dp;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-01-10:08
 */
public class CanPartitionSolution {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 5, 11};
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(canPartition(nums1));
        System.out.println(canPartition(nums2));
    }

    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;// 背包容量
        int dp[] = new int[target + 1];
        for (int i = 0; i < len; i++) {// 遍历物品
            for (int j = target; j >= nums[i]; j--) {// 遍历背包
                dp[j] = Math.max(dp[j], (dp[j - nums[i]] + nums[i]));
            }
            if (dp[target] == target) {
                return true;
            }
        }
        return false;
    }
}
