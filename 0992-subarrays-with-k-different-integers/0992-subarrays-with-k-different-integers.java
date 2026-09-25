class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarrayWithAtMostK(nums,k) - subarrayWithAtMostK(nums,k-1);
    }
    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        int l =0, r=0, ans =0;
        while(r<nums.length) {
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.size() > k ){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0) {
                    hm.remove(nums[l]);
                }
                l++;
            }
            ans += r-l+1;
            r++;
        }
        return ans;
    }
}