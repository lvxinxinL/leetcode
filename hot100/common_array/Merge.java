package hot100.common_array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. 合并区间
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-06-9:58
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> resList = new LinkedList<>();
        // 使用自定义的 Comparator 对二维数组进行排序
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        // 最小左边界
        int start = intervals[0][0];
        int rightMostBound = intervals[0][1];
        // 比较每个数组的第一个元素
        for (int i = 0; i < intervals.length; i++) {
            // 如果左边界大于大于最大右边界，不重叠，新数组
            if (intervals[i][0] > rightMostBound) {
                resList.add(new int[]{start, rightMostBound});
                start = intervals[i][0];// 更新左边界
                rightMostBound = intervals[i][1];// 更新右边界
            } else {
                // 数组重叠，更新最大右边界
                rightMostBound = Math.max(rightMostBound, intervals[i][1]);
            }
        }
        resList.add(new int[]{start, rightMostBound});
        return resList.toArray(new int[resList.size()][]);
    }
}
