class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int target = totalSum - x;
        if(target < 0) return -1;
        if(target == 0) return nums.length;

        int left = 0;
        int sum = 0;
        int longest = -1;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }
            if(sum == target) {
                longest = Math.max(longest, right-left+1);
            }
        }
        return longest == -1 ? -1 : nums.length - longest;
    }
}