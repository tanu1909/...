class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMax=0, currMin=0;

        for(int num:nums){
            currMax = Math.max(currMax+num, num);
            currMin = Math.min(currMin+num, num);
            
            maxSum = Math.max(maxSum, currMax);             
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }
        // case1--> max subarray is not circular---> take maxSum
        //case2--> is circular--> totalSum - minSubarraySum

        //ans--max of both cases
        return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum; //incase all elements are -ve return maxSum
    }
}