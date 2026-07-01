class Solution {
    int mod = (int)1e9 + 7;
    int[][] dp ; //dice remaining, currSum

    private int solve(int n, int k, int target){
        if (target == 0 && n == 0) return 1;
        if (n == 0 || target <= 0) return 0;

          if (dp[n][target] != -1) return (int) (dp[n][target] % mod);

          int cnt=0;
          for(int i=1; i<=k ; i++){
            cnt = (cnt+solve(n-1,k,target-i)) % mod;
          }

        return dp[n][target] = cnt%mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];

        for(int [] row :dp ){
            Arrays.fill(row, -1);
        }

return solve(n,k,target);
    }
}