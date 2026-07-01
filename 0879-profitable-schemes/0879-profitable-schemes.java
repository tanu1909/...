class Solution {
    int MOD = 1000000007;
    int[][][] dp;

    private int f(int idx, int n, int currProfit, int minProfit,
                  int currPeople, int[] group, int[] profit) {

        if (currPeople > n) return 0;

        if (idx == group.length) {
            return currProfit >= minProfit ? 1 : 0;
        }

        if (dp[idx][currProfit][currPeople] != -1) {
            return dp[idx][currProfit][currPeople];
        }

        int notTaken = f(idx + 1, n, currProfit, minProfit,
                         currPeople, group, profit);

        int taken = f(idx + 1, n,
                      Math.min(currProfit + profit[idx], minProfit),
                      minProfit,
                      currPeople + group[idx],
                      group, profit);

        return dp[idx][currProfit][currPeople] =
                (notTaken + taken) % MOD;
    }

    public int profitableSchemes(int n, int minProfit,
                                 int[] group, int[] profit) {

        dp = new int[group.length + 1][minProfit + 1][n + 1];

        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        return f(0, n, 0, minProfit, 0, group, profit);
    }
}