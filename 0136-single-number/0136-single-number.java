public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 2, 1};
        System.out.println(solution.singleNumber(nums1)); // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums2)); // Output: 4

        int[] nums3 = {1};
        System.out.println(solution.singleNumber(nums3)); // Output: 1
    }
}
