package hot100.two_pointers;

/**
 * 11. 盛最多水的容器
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-03-11:21
 */
public class MaxAreaSolution {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        int max = 0;
        while (l < r) {
            area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(area, max);// 记录当前最大盛水量
            // 移动高度较小的板子
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
