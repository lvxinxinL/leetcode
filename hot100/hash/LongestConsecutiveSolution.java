package hot100.hash;

import java.util.*;

/**
 * 128. 最长连续序列
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-02-10:25
 */
public class LongestConsecutiveSolution {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    public static int longestConsecutive(int[] nums) {
        // 查找问题 => hashTable
        if(nums.length == 0) return 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 将元素映射到哈希表，找以每一个元素开头的连续序列的长度，最后找出最长的长度
        for(int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        int maxLength = 0;// 存储序列的长度
        for(int i = 0; i < nums.length; i++) {
            // 如果 x 和 x + 1 同时存在，x + 1 开头的序列长度肯定小于 x 开头的，直接跳过
            if (!hashMap.containsValue(nums[i] - 1)) {
                int queLen = 1;// 元素自己的长度
                int num = nums[i];
                while(hashMap.containsValue(num + 1)) {
                    queLen++;
                    num++;
                }
                maxLength = Math.max(queLen, maxLength);
            }
        }
        return maxLength;
    }
}
