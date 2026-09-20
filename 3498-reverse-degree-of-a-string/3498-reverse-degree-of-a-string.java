class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0;i<n;i++) {
            res = res + (i+1)*('z'-s.charAt(i)+1);
        }
        return res;
    }
}