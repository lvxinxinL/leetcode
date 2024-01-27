package dp;

/**
 * 整数拆分
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-01-27-10:20
 */
public class IntegerBreakSolution {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
    /**
     2 <= k <= n / 2;   fork 循环
     1. dp[i]：将 i 拆分为两个或两个以上的正整数时，所能得到的最大乘积
     2. dp[i] = Math.max((j * (i - j)), j * dp[i - j]);//max(只拆成两个，继续拆)
     3. 初始化：dp[2] = 1; dp[0] dp[1] 不能拆，初始化没有意义
     4. 从前往后遍历
     5. 举例推导 dp 数组
     */
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
