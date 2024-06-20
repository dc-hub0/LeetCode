import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); // Sort the positions to simplify the search process
        int n = position.length;
        int left = 1, right = position[n - 1] - position[0]; // Initialize the search range

        while (left < right) {
            int mid = left + (right - left + 1) / 2; // Adjusted mid calculation
            if (isValid(position, m, mid)) {
                left = mid; // Move towards higher values of mid if valid
            } else {
                right = mid - 1; // Move towards lower values of mid if not valid
            }
        }

        return left; // Return the maximum minimum magnetic force found
    }

    // Check if it's possible to distribute the balls with a minimum magnetic force of mid
    private boolean isValid(int[] position, int m, int mid) {
        int count = 1;
        int prevPos = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prevPos >= mid) {
                count++;
                prevPos = position[i];
            }
        }
        return count >= m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println("Max Minimum Magnetic Force: " + solution.maxDistance(position1, m1)); // Output: 3

        // Test case 2
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println("Max Minimum Magnetic Force: " + solution.maxDistance(position2, m2)); // Output: 999999999
    }
}
