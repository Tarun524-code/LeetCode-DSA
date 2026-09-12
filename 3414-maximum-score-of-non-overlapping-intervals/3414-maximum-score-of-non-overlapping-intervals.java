class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size(), i = 0;
        int[][] a = new int[n][4];
        for (List<Integer> in : intervals)
            a[i] = new int[]{in.get(0), in.get(1), in.get(2), i++};
        
        Arrays.sort(a, (x, y) -> Integer.compare(x[1], y[1]));
        
        long[][] dpW = new long[5][n + 1];
        int[][][] dpI = new int[5][n + 1][0];
        
        for (i = 1; i <= n; i++) {
            int l = 0, r = i - 2, p = 0;
            while (l <= r) {
                int m = (l + r) / 2;
                if (a[m][1] < a[i - 1][0]) { 
                    p = m + 1; 
                    l = m + 1; 
                } else {
                    r = m - 1;
                }
            }
            
            for (int k = 1; k <= 4; k++) {
                long w1 = dpW[k][i - 1], w2 = dpW[k - 1][p] + a[i - 1][2];
                int[] i1 = dpI[k][i - 1];
                int[] i2 = Arrays.copyOf(dpI[k - 1][p], dpI[k - 1][p].length + 1);
                i2[i2.length - 1] = a[i - 1][3];
                Arrays.sort(i2);
                
                int cmp = 0;
                for (int x = 0; x < Math.min(i1.length, i2.length) && cmp == 0; x++) 
                    cmp = i1[x] - i2[x];
                if (cmp == 0) cmp = i1.length - i2.length;
                
                boolean take = w2 > w1 || (w2 == w1 && cmp > 0);
                dpW[k][i] = take ? w2 : w1;
                dpI[k][i] = take ? i2 : i1;
            }
        }
        
        return dpI[4][n];
    }
}