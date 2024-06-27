public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result1 = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // Output: [3, 4]

        int[] result2 = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // Output: [-1, -1]

        int[] result3 = solution.searchRange(new int[]{}, 0);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // Output: [-1, -1]
    }
}
