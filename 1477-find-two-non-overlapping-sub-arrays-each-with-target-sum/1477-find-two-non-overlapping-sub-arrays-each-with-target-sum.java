class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // dp[i] stores the minimum length of a valid subarray ending at or before index i
        int[] dp = new int[n];
        
        int currentSum = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            // Shrink window if sum exceeds target
            while (currentSum > target) {
                currentSum -= arr[left];
                left++;
            }

            // Valid subarray found ending at 'right'
            if (currentSum == target) {
                int len = right - left + 1;

                // If a valid non-overlapping subarray exists before 'left', calculate total sum
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + dp[left - 1]);
                }

                // Update minLen with current valid subarray length
                minLen = Math.min(minLen, len);
            }

            // Store the best (minimum) subarray length found up to index 'right'
            dp[right] = minLen;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}