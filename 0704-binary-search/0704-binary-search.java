class Solution {
    public int search(int[] nums, int target) {
    //     int l=0;
    //     int h = nums.length-1;
       
    //    while(l<=h){
    //      int m = l+ (h-l)/2;

    //      if(target<nums[m]){
    //         h = m-1;
    //      }
    //      else if(target>nums[m]){
    //         l = m+1;
    //      }
    //      else{
    //         return m;
    //      }
    //    }
    //    return -1; 

    int n = nums.length;
    int low=0; 
    int high = n-1;
    while(low<=high){
        int mid = low + (high-low)/2;

        if(nums[mid]==target)return mid;
        else if(nums[mid]<target)low=mid+1;
        else high = mid-1;
    }
return -1;
    }
}