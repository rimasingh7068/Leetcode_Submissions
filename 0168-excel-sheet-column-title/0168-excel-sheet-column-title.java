class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            char c = (char) ('A' + (columnNumber % 26));
            result.append(c);
            columnNumber /= 26;
        }
        
        return result.reverse().toString();
    }
}