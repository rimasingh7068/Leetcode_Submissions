class Solution {
    public int mySqrt(int x) {
        // Base cases for 0 and 1
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Use division (mid <= x / mid) instead of multiplication (mid * mid <= x)
            // to avoid integer overflow when mid * mid exceeds Integer.MAX_VALUE
            if (mid <= x / mid) {
                ans = mid;      // Mid is a valid candidate, save it
                left = mid + 1; // Try to find a larger integer square root
            } else {
                right = mid - 1; // Mid is too large, search in the left half
            }
        }

        return ans;
    }
}