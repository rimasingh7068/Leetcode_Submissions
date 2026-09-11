class Solution {
    public int totalNumbers(int[] digits) {
        // Count frequency of each digit in the input array
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }

        int validCount = 0;

        // Iterate through all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;        // Hundreds place
            int d2 = (num / 10) % 10;  // Tens place
            int d3 = num % 10;         // Units place

            // Count required frequency of each digit for the current number
            int[] currentCount = new int[10];
            currentCount[d1]++;
            currentCount[d2]++;
            currentCount[d3]++;

            // Check if the input digits array can satisfy the required frequencies
            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (currentCount[i] > count[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                validCount++;
            }
        }

        return validCount;
    }
}