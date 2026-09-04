class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // minSuffix[i] stores the minimum value in nums[i...n-1]
        int[] minSuffix = new int[n];
        minSuffix[n - 1] = nums[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(nums[i], minSuffix[i + 1]);
        }
        
        int maxPrefix = 0;
        
        // Find the smallest stable index
        for (int i = 0; i < n; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);
            
            if (maxPrefix - minSuffix[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}