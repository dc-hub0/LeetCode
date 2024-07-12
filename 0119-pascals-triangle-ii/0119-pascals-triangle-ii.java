import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Base case
        row.add(1);
        
        // Build the rest of the rows
        for (int i = 1; i <= rowIndex; i++) {
            // Add a new element at the end to maintain the size
            row.add(1);
            
            // Update elements in between (from the end to avoid overwriting)
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}
