class Solution {
    private long time(int[] piles, int speed){
        long t=0;
        for(int i=0; i<piles.length; i++){
            t+= (int)Math.ceil((piles[i]+speed-1)/speed);
        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();

int low = 1;
while(low<=high){
    int mid = low+(high-low)/2;
    if(time(piles, mid)>h)low=mid+1;
    else high=mid-1;
}
return low;
    }
}