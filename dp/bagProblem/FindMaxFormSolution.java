package dp.bagProblem;

/**
 * 474. 一和零
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-04-10:58
 */
public class FindMaxFormSolution {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int maxForm = findMaxForm(strs, 5, 3);
        System.out.println(maxForm);
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        // 物品：strs，背包容量：m 和 n（两个维度的背包）
        int zeroNum, oneNum;
        int[][] dp = new int[m + 1][n + 1];// dp[i][j] 表示最多有 i 个 0 和 j 个 1 的字符串子集的最大长度是 dp[i][j];
        for (String str : strs) {
            zeroNum = 0;
            oneNum = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            for (int i = m; i >= zeroNum; i--) {// i 是背包能装的 0 的最大的个数，一定要大于该字符串中 0 的个数，
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
