class Solution {
    public int numberOfSets(int n, int k) {
        long mod = 1000000007, num = 1, den = 1;
        for (int i = 1; i <= 2 * k; i++) {
            num = (num * (n + k - i)) % mod;
            den = (den * i) % mod;
        }
        return (int) ((num * power(den, mod - 2, mod)) % mod);
    }
    
    public long power(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}