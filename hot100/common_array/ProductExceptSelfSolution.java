package hot100.common_array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-06-11:05
 */
public class ProductExceptSelfSolution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] answer = productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] productExceptSelf(int[] nums) {
        // 左侧所有元素的乘积 * 右侧所有元素的乘积
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int ansLeft = 1;
            int ansRight = 1;
            int left = 0;
            int right = i + 1;
            while(left < i) {
                ansLeft *= nums[left];
                left++;
            }
            while(right < n) {
                ansRight *= nums[right];
                right++;
            }
            answer[i] = ansLeft * ansRight;
        }
        return answer;
    }
}
