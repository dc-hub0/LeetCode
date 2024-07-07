class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int writeIndex = 2; // Start from the third element

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println(k1); // Output: 5
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Output: 1 1 2 2 3
        }
        System.out.println();

        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println(k2); // Output: 7
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // Output: 0 0 1 1 2 3 3
        }
        System.out.println();
    }
}
