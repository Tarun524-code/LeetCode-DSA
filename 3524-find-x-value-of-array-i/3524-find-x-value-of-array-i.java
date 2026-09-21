class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k]; 
        long[] nextDp = new long[k];
        for (int num : nums) {
            int val = num % k;
            for (int i = 0; i < k; i++) 
                nextDp[i] = 0;
            nextDp[val] = 1;
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) 
                    nextDp[(i * val) % k] += dp[i];
            }
            for (int i = 0; i < k; i++) {
                ans[i] += nextDp[i];
                dp[i] = nextDp[i];
            }
        }
        return ans;
    }
}