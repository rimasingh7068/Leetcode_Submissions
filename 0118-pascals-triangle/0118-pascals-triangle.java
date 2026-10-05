import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                // The first and last elements of each row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two elements directly above in the previous row
                    int prev1 = triangle.get(i - 1).get(j - 1);
                    int prev2 = triangle.get(i - 1).get(j);
                    row.add(prev1 + prev2);
                }
            }
            
            triangle.add(row);
        }

        return triangle;
    }
}