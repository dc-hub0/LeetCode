import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { 
                int left = i + 1, right = n - 1, target = -nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; 
                        while (left < right && nums[right] == nums[right - 1]) right--; 
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + solution.threeSum(nums1)); 

        // Test case 2
        int[] nums2 = {0, 1, 1};
        System.out.println("Triplets: " + solution.threeSum(nums2));

        // Test case 3
        int[] nums3 = {0, 0, 0};
        System.out.println("Triplets: " + solution.threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}
