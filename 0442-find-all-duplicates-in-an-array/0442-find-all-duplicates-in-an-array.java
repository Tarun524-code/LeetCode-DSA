// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         HashMap<Integer,Integer> hm= new HashMap<>();
//         ArrayList<Integer> al = new ArrayList<>();
//         for(int num : nums) {
//             hm.put(num,hm.getOrDefault(num,0)+1);
//             if(hm.get(num)==2) {
//                 al.add(num);
//             }
//         }
//         return al;
//     }
// }
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : nums) {
            int idx = Math.abs(num)-1;
            if(nums[idx] < 0) {
                al.add(idx+1);
            }
            else {
                nums[idx] = -nums[idx];
            }
        }
        return al;
    }
}