class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int totalN = n + k - 1;
        int totalK = 2 * k;
        
        long numerator = 1;
        long denominator = 1;
        
        for (int i = 1; i <= totalK; i++) {
            numerator = (numerator * (totalN - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }
        
        // nCr % MOD = (numerator * modularInverse(denominator)) % MOD
        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }
    
    // Fermat's Little Theorem to compute modular inverse: base^(MOD - 2) % MOD
    private long modInverse(long base, int mod) {
        return power(base, mod - 2, mod);
    }
    
    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}