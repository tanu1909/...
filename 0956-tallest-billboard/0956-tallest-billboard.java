class Solution {
   
    // private int solve(int[] rods,  int idx, int l1, int l2){
    //     if(idx==rods.length){
    //         if(l1==l2) return l1;
    //         else return 0;
    //     }
       

    //     int pickL1 = solve(rods, idx+1, l1 + rods[idx], l2);
    //     int pickL2 = solve(rods, idx+1, l1, l2+rods[idx]);
    //     int skip = solve(rods, idx+1, l1, l2);

    //     return Math.max(skip, Math.max(pickL1, pickL2));

    // }







 // int[][][] dp = new int[21][5001][5001]; //idx, l1, l2....MLE..therfore we'll use diff of l1 & l2.....dp[idx][diff]

 int[][] dp = new int[21][10003]; //-5000<=diff<=5000..diff can be neg, so we;; use an offset of 5000
 int offset = 5000;


    private int mem(int[] rods, int i, int diff){
        if(i>=rods.length){
            if(diff==0)return 0;
            else return Integer.MIN_VALUE;
        }

        if(dp[i][diff+offset]!=-1)return dp[i][diff+offset];

        //l1-l2=diff
        //lets add to l1....(l1+x) - l2 = diff....(l1 - l2)+x=diff..we are adding x to the original diff in this case

        //adding to l2 will rseult in originalDiff - x
    int x=rods[i];
        int left = rods[i]+mem(rods, i+1, diff+x);
        int right = rods[i]+mem(rods, i+1, diff-x);
        int skip = mem(rods, i+1, diff);

        return dp[i][diff+offset] = Math.max(skip, Math.max(left, right));
    }

    public int tallestBillboard(int[] rods) {
       
        // return solve(rods, 0, 0, 0);
         for(int[]r:dp){
        Arrays.fill(r, -1);
        }
        return mem(rods,0,0)/2; // this will return total sum of both rods, we need height of one rod
        
    }
}