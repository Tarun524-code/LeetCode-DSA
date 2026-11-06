class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] result = new int[m];
        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        
        int logLeft = 0;
        int logRight = 0;
        
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int qIndex = sortedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;

            while (logRight < logs.length && logs[logRight][1] <= windowEnd) {
                int serverId = logs[logRight][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                logRight++;
            }
            
            while (logLeft < logs.length && logs[logLeft][1] < windowStart) {
                int serverId = logs[logLeft][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                logLeft++;
            }

            result[qIndex] = n - activeServers;
        }
        
        return result;
    }
}