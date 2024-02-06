package hot100.common_array;

/**
 * 189. 轮转数组
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-06-10:14
 */
public class RotateSolution {
    public static void main(String[] args) {
        int[] nums = {-1};
        rotate2(nums, 2);
    }

    public static void rotate1(int[] nums, int k) {
        // 方法一：使用额外的数组
        int n = nums.length;
        int[] newNums = new int[n];
        int end = n - 1;// nums 数组最后一个元素的下标
        for (int i = 0; i < n; i++) {
            newNums[(i + k) % n] = nums[i];
        }
        System.arraycopy(newNums, 0, nums, 0, n);
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 方法二：翻转数组
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while(start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
