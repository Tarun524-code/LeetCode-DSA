class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = n+1;
        int ans = max;
        int minlen = ans;
        int sum = 0;
        int l = 0;
        for(int r = 0; r < n; r++) {
            sum += arr[r];
            while(sum > target) {
                sum -= arr[l];
                l++;
            }
            if(sum == target) {
                int len = r-l+1;
                if(l>0) {
                    ans = Math.min(ans, len+dp[l-1]);
                }
                minlen = Math.min(minlen, len);
            }
            dp[r] = minlen;
        }
        return ans >= max ? -1:ans;
    }
}