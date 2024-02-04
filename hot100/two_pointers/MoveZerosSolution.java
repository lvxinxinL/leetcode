package hot100.two_pointers;

import java.util.Arrays;

/**
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-01-10:28
 */
public class MoveZerosSolution {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int len =  nums.length, left = 0, right = 0;
        while(right < len) {
            if(nums[right] != 0) {// 右指针遇到非零数就和左指针交换
                swap(nums, left, right);
                left++;
            }
            right++;// 遇到 0，右指针＋1，左指针不变
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
