public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] cuts = new int[n];

        // Fill the isPalindrome table
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true; // Single letter palindromes
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        isPalindrome[i][j] = true; // Two letter palindrome
                    } else {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1]; // Expand palindrome
                    }
                }
            }
        }

        // Calculate the minimum cuts
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                cuts[i] = 0;
            } else {
                int minCuts = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        minCuts = Math.min(minCuts, cuts[j] + 1);
                    }
                }
                cuts[i] = minCuts;
            }
        }

        return cuts[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String s1 = "aab";
        System.out.println(solution.minCut(s1)); // Output: 1

        String s2 = "a";
        System.out.println(solution.minCut(s2)); // Output: 0

        String s3 = "ab";
        System.out.println(solution.minCut(s3)); // Output: 1
    }
}
