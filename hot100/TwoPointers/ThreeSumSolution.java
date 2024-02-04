package hot100.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-04-11:02
 */
public class ThreeSumSolution {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();// 存储结果
        Arrays.sort(nums);// 对数组排序，跳过重复元素
        // nums[first] + nums[second] + nums[third] = 0
        for (int first = 0; first < nums.length; first++) {
            // 跳过重复元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // nums[second] + nums[third] = -nums[first];
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {// 跳过重复元素
                    continue;
                }
                int third = nums.length - 1;
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                if (second == third) break;

                // 找到符合的三元组，加入结果集
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ansList.add(list);
                }
            }
        }
        return ansList;
    }
}
