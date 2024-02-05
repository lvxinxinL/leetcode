package hot100.common_array;

/**
 * 53. 最大子数组和
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-05-10:07
 */
public class MaxSubArraySolution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        // 暴力解法
        if(nums.length == 1) {
            return nums[0];
        }
        int count = 0;// 当前连续子数组的最大和初始化为 nums[0]
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count);
            // if(nums[i] < 0){// 遇到负数 sum 一定变小，重置 sum
            //     count = 0;
            // }
            // 注意这里不是遇到负数就要重置，有可能加上下一个总和会更大所以判断的是当前的和 count
            if(count <= 0) {
                count = 0;// 这一步 妙啊 相当于重置了最大子数组的起始位置！
            }
        }
        return sum;
    }
}
