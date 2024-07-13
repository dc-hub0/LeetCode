class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize variables
        int minPrice = prices[0];
        left[0] = 0;

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }

        // Initialize variables
        int maxPrice = prices[n - 1];
        right[n - 1] = 0;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }

        // Find the maximum sum of left[i] + right[i]
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }
}
