class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long res = (long) k1 + (long) k2;
        int maxDiff = 0;
        int[] arr = new int[100001];
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            arr[diff]++;
            maxDiff = Math.max(maxDiff, diff);
        }
        
        for (int d = maxDiff; d > 0 && res > 0; d--) {
            if (arr[d] == 0) continue;
            
            long take = Math.min(res, (long) arr[d]);
            arr[d] -= take;
            arr[d - 1] += take;
            res -= take;
        }
        
        if (res > 0) {
            return 0;
        }
        
        long minSum = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (arr[d] > 0) {
                minSum += (long) arr[d] * d * d;
            }
        }
        
        return minSum;
    }
}