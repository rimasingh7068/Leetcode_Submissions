class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long start = 1000; // 10^3 is the minimum number for 1 comma

        while (n >= start) {
            totalCommas += (n - start + 1);
            
            // Prevent potential 64-bit long overflow when multiplying start by 1000
            if (start > Long.MAX_VALUE / 1000) {
                break;
            }
            start *= 1000;
        }

        return totalCommas;
    }
}