class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int targetCount = 0;
        for(int num : nums) {
            if(num < target) {
                count++;
            } else if (num == target) {
                targetCount++;
            }
        }
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<targetCount;i++) {
            al.add(count+i);
        }
        return al;
    }
}