class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            long solve = questions[i][0];
            int next = i + questions[i][1] + 1; //next valid index

            if (next < n)
                solve += dp[next];

            long skip = (i + 1 < n) ? dp[i + 1] : 0;

            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}