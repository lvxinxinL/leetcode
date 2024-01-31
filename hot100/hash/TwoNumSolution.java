package hot100.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-31-10:39
 */
public class TwoNumSolution {
    public static void main(String[] args) {
        int[] nums = {2,11,7,15};
        System.out.println(Arrays.toString(twoSumByFor(nums, 9)));
        System.out.println(Arrays.toString(twoSumByHash(nums, 9)));
    }

    public static int[] twoSumByFor(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++) {
            int temp = target - nums[i];
            for(int j=i+1; j < nums.length; j++) {
                if (nums[j] == temp) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static int[] twoSumByHash(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return res;
    }

}
