class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3}))); // [1, 2, 4]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1}))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9}))); // [1, 0]
    }
}
