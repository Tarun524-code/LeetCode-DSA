class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long ans = 0;
        long cost = 0;
        Deque<int[]> dq = new ArrayDeque<>();        
        for (int i = nums.length - 1, j = nums.length - 1; i >= 0; --i) {
            int num = nums[i];
            int count = 1;
            
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] prev = dq.pollLast();
                cost += (long) (num - prev[0]) * prev[1];
                count += prev[1];
            }
            dq.offerLast(new int[]{num, count});            
            while (cost > k) {
                int[] first = dq.peekFirst();
                cost -= (long) (first[0] - nums[j]);
                j--;
                if (first[1] > 1) {
                    first[1]--;
                } else {
                    dq.pollFirst();
                }
            }
            ans += j - i + 1;
        }
        return ans;
    }
}