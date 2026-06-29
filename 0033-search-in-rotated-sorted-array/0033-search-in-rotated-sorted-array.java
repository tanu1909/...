class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int hi = n - 1;

        while (low <= hi) {
            int mid = low + (hi - low) / 2;   


            if(nums[mid]==target) return mid;

            if(nums[mid]>=nums[low]){
                if(nums[low]<=target && nums[mid]>=target)hi = mid-1;
                else low = mid+1;
            }
            else{
                if(nums[mid]<=target && nums[hi]>=target)low=mid+1;
                else hi = mid-1;
            }

        }

        return -1;

    }
}