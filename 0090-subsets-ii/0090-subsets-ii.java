import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset)); // Add current subset to result
        
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            subset.add(nums[i]); // Include nums[i] in the current subset
            backtrack(nums, i + 1, subset, result); // Recursively generate subsets starting from i + 1
            subset.remove(subset.size() - 1); // Backtrack: remove nums[i] from the current subset
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {1, 2, 2};
        List<List<Integer>> result1 = solution.subsetsWithDup(nums1);
        System.out.println(result1); // Output: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        
        // Example 2
        int[] nums2 = {0};
        List<List<Integer>> result2 = solution.subsetsWithDup(nums2);
        System.out.println(result2); // Output: [[], [0]]
    }
}
