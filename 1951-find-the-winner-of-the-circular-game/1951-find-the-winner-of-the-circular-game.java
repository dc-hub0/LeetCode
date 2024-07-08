class Solution {
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }
    
    private int josephus(int n, int k) {
        int winner = 0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 5, k1 = 2;
        System.out.println(solution.findTheWinner(n1, k1)); // Output: 3

        int n2 = 6, k2 = 5;
        System.out.println(solution.findTheWinner(n2, k2)); // Output: 1
    }
}
