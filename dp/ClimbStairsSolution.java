package dp;

class ClimbStairsSolution {
    public static void main(String[] args) {
        int stairs = 5;
        System.out.println(climbStairs1(stairs));
        System.out.println(climbStairs2(stairs));
    }
    public static int climbStairs1(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}