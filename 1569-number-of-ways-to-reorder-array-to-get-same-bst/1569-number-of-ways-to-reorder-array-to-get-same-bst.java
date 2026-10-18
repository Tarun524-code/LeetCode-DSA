class Solution {
    static final long MOD = 1000000007;
    long[] fact, invFact;
    int[] left, right, size;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        fact = new long[n + 1];
        invFact = new long[n + 1];
        left = new int[n + 1];
        right = new int[n + 1];
        size = new int[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i % MOD;

        invFact[n] = pow(fact[n], MOD - 2);
        for (int i = n; i > 0; i--)
            invFact[i - 1] = invFact[i] * i % MOD;

        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++)
            pos[nums[i]] = i;

        int[] stack = new int[n];
        int top = 0;

        for (int x = 1; x <= n; x++) {
            int last = 0;

            while (top > 0 && pos[stack[top - 1]] > pos[x])
                last = stack[--top];

            if (top > 0)
                right[stack[top - 1]] = x;

            left[x] = last;
            stack[top++] = x;
        }

        int root = stack[0];
        return (int)((dfs(root) - 1 + MOD) % MOD);
    }

    long dfs(int x) {
        if (x == 0) return 1;

        long l = dfs(left[x]);
        long r = dfs(right[x]);

        int a = size[left[x]];
        int b = size[right[x]];
        size[x] = a + b + 1;

        return comb(a + b, a) * l % MOD * r % MOD;
    }

    long comb(int n, int r) {
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}