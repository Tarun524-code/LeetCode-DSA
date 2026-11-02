class Solution {
    public int minMoves2(int[] nums) {
        int mid = (nums.length - 1) / 2;
        int target = quickselect(nums, 0, nums.length - 1, mid);
     
        int count = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] > target) {
                count += nums[i] - target;
            }
            else {
                count += target - nums[i];
            }
        }
        return count;
    }

    public int quickselect(int[] arr, int low, int high, int mid ) {
        if(low >= high) {
            return arr[low];
        }
        int m = low + (high - low) / 2;
        int s = low;
        int e = high;

        int p = arr[m];
        while(s <= e) {
            while(arr[s] < p) {
                s ++;
            }
            while(arr[e] > p) {
                e --;
            }
            if(s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s ++;
                e --;
            }
        }
        if(s <= mid) {
            return quickselect(arr, s, high, mid);
        } 
        if(e >= mid) {
            return quickselect(arr, low, e, mid);
        }
        return arr[mid];
      
    }
}