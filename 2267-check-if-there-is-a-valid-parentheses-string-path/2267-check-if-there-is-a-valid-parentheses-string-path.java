class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length, max = (m + n + 1) / 2;
        
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') 
            return false;
            
        return dfs(grid, 0, 0, 0, new boolean[m][n][max]);
    }

    private boolean dfs(char[][] g, int r, int c, int k, boolean[][][] vis) {
        if (g[r][c] == '(') {
            k++;
        } else {
            k--;
        }
        
        if (k < 0 || k >= vis[0][0].length || vis[r][c][k]) 
            return false;
        
        if (r == g.length - 1 && c == g[0].length - 1) 
            return k == 0;
        
        vis[r][c][k] = true;
        
        if (r + 1 < g.length && dfs(g, r + 1, c, k, vis)) 
            return true;
        if (c + 1 < g[0].length && dfs(g, r, c + 1, k, vis)) 
            return true;
        
        return false;
    }
}