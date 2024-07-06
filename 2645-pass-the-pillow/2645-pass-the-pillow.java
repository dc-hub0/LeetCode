class Solution {
    public int passThePillow(int n, int time) {

        int pos = 1;
        int direction = 1;

        for (int t = 0; t < time; t++) {
            pos += direction;

            if (pos == n || pos == 1) {
                direction *= -1;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.passThePillow(4, 5)); // Output: 2
        System.out.println(solution.passThePillow(3, 2)); // Output: 3
    }
}
