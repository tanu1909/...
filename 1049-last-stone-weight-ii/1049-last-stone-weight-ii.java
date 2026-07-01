class Solution {
    int halfSum;
    int sum;
    int[][] dp; //i, curr
    private int solve(int[] stones, int curr, int i){
        if(i==stones.length || curr>=halfSum)return Math.abs(curr - (sum-curr)); //curr..first subset sum, sum-curr..second subset sum

        if(dp[i][curr]!=-1){
            return dp[i][curr];
        }

        int pick = solve(stones, curr+stones[i], i+1);
        int notPick = solve(stones, curr, i+1);

        return dp[i][curr] = Math.min(pick, notPick);
    }


    public int lastStoneWeightII(int[] stones) {
         sum = 0;
        for(int stone: stones){
            sum+=stone;
        }

        dp = new int[stones.length+1][sum+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        halfSum = sum/2;
        return solve(stones, 0, 0);

    }
}