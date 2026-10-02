class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0, l = 0, lmax = 0, r = n-1, rmax = 0;
        while(l<=r) {
            if(height[l] <= height[r]) {
                if(height[l] >= lmax) {
                    lmax = height[l];
                }
                else {
                    water += lmax - height[l];
                }
                l++;
            }   
            else {
                if(height[r] >= rmax) {
                    rmax = height[r];
                }
                else {
                    water += rmax - height[r];
                }
                r--;
            }
        }
        return water;
    }
}