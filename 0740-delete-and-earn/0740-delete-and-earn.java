class Solution {
    public int deleteAndEarn(int[] nums) {
        //freq map
        if(nums==null ||nums.length==0)return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }


        //sort the array and remove duplicates
        int[] arr = new int[map.size()];    
        int index = 0;
        for (int key : map.keySet()) {
            arr[index++] = key;
        }

        Arrays.sort(arr);
        

        //if adjacent have a diff of 1..dont pick adj, pick max(dp[i-1], dp[i-2]+arr[i])...use the freq map to calculate the points incase an element is occuring multiple times

        //if adj dont have diff of 1,pick the curr elem and add to ans... dp[i]=dp[i-1]+arr[i];

        int[] dp = new int[arr.length];
        dp[0]=arr[0] * map.get(arr[0]); 
        if(arr.length==1)return dp[0];

        if(arr[1]-arr[0] == 1) dp[1] = Math.max(dp[0], arr[1]*map.get(arr[1]));
        else dp[1] = dp[0] + (arr[1] * map.get(arr[1]));



        for(int i=2; i<arr.length; i++){
            if(arr[i] - arr[i-1] != 1){
                dp[i] = dp[i-1] + arr[i]*map.get(arr[i]);
            }
            else dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]*map.get(arr[i]));
        }


        return dp[arr.length-1];
    }
}