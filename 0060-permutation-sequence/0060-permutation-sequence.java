class Solution {
    public String getPermutation(int n, int k) {
        // Calculate factorial of each number up to n
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // List of digits to use for permutations
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
        
        // k is 1-based, so convert it to 0-based for easier calculations
        k--;
        
        // Build the k-th permutation sequence
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(digits.get(index));
            digits.remove(index); // Remove used digit
            k %= factorial[i]; // Update k for the next iteration
        }
        
        return sb.toString();
    }
}
