class Solution {
     private boolean possible(int[] nums, long maxSum, long maxPartitions){
        long partitions = 1;
        long currSum=0;

        for(int num:nums){
            if(num>maxSum)return false;
            if(num+currSum <= maxSum){ //if does not exceed max poss.sum, then we can add
                currSum+=num;
            }else{ //if exceeds maxSum, start new partition
                partitions++;
                currSum=num;
                if(partitions> maxPartitions)return false;
            }
        }
         return true;
    }

    public int shipWithinDays(int[] nums, int k) {
         long totalSum=0;
        long largest=nums[0];

        for(int num:nums){
            totalSum+=num;
            largest = Math.max(largest, num);
        }

        //  Max Element <= ans <=totalSum....upper nd lower bound for Bin search

       long low = largest;
       long high = totalSum;
       
       while(low<=high){
        long mid = low + (high- low)/2;

        if(possible(nums, mid, k)) high = mid-1; //try smaller partition
        else low = mid+1; //if not possible try larger sum partition
       }
       return (int)low;
    }
}