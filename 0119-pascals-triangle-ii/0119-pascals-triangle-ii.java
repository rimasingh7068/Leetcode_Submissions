import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // The first element of every row is always 1
        row.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            // Add a placeholder 1 at the end to expand the list size for the current row
            row.add(1);
            
            // Update the elements from right to left to avoid overwriting values we still need
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}