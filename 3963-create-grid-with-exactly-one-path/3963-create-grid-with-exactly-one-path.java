class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        res[0] = sb.toString();

        sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append("#");
        }
        sb.append(".");
        
        for(int i = 1; i < m; i++) {
            res[i] = sb.toString();
        }
        
        return res;
    }
}