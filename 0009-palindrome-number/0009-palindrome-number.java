class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (e.g., -121 -> 121-)
        // Also, if the last digit is 0, the first digit must be 0, which only happens for 0 itself.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reversing only half of the number to prevent integer overflow
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When length is even: x == reversedHalf (e.g., 1221 -> x=12, reversedHalf=12)
        // When length is odd: x == reversedHalf / 10 (e.g., 121 -> x=1, reversedHalf=12 -> 12/10 = 1)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}