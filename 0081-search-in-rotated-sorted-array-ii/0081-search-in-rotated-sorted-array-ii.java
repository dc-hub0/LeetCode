class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // If the left half is sorted
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // If the right half is sorted
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // If nums[left] == nums[mid], we cannot determine which part is sorted, so we reduce the search space
            else {
                if (nums[left] == nums[mid]) {
                    left++;
                }
                if (nums[right] == nums[mid]) {
                    right--;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println(solution.search(nums1, target1)); // Output: true

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println(solution.search(nums2, target2)); // Output: false
    }
}
