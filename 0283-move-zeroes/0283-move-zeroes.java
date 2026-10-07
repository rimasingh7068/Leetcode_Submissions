class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0; // Pointer for the position of the next non-zero element

        for (int right = 0; right < nums.length; right++) {
            // When we encounter a non-zero element, swap it to the left pointer
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
            }
        }
    }
}