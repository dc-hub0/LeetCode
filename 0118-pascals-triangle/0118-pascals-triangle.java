class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        
        // Base case: first row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1); // first element
        
        // Build the rest of the rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i - 1);
            
            // First element of each row is always 1
            row.add(1);
            
            // Compute the elements in between
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // Last element of each row is always 1
            row.add(1);
            
            // Add current row to triangle
            triangle.add(row);
        }
        
        return triangle;
    }
}
