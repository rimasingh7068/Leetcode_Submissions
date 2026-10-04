class Solution {
    public boolean checkValidString(String s) {
        // minOpen tracks the minimum possible number of open '(' required
        // maxOpen tracks the maximum possible number of open '(' allowed
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }

            // If maxOpen falls below 0, we have too many ')' characters
            if (maxOpen < 0) {
                return false;
            }

            // minOpen cannot be negative since we can't have negative open brackets
            if (minOpen < 0) {
                minOpen = 0;
            }
        }

        // The string is valid if we can balance all open brackets (minOpen reaches 0)
        return minOpen == 0;
    }
}