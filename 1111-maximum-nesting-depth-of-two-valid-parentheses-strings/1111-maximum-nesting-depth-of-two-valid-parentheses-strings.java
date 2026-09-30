class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int[] res = new int[chars.length];
        int depth = 0;
        
        for (int i = 0; i < chars.length; i++) {
            res[i] = chars[i] == '(' ? ++depth & 1 : depth-- & 1;
        }
        
        return res;
    }
}