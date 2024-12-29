class Solution {
  int rob(List<int> nums) {
    if (nums.isEmpty) {
      return 0;
    }
    
    if (nums.length == 1) {
      return nums[0];
    }

    // Helper function to solve the linear House Robber problem
    int robLinear(List<int> nums) {
      int prev = 0;
      int curr = 0;
      for (var num in nums) {
        int temp = curr;
        curr = (curr > prev + num) ? curr : prev + num;
        prev = temp;
      }
      return curr;
    }

    // Case 1: Rob houses from index 1 to n-1 (exclude the first house)
    int case1 = robLinear(nums.sublist(1));

    // Case 2: Rob houses from index 0 to n-2 (exclude the last house)
    int case2 = robLinear(nums.sublist(0, nums.length - 1));

    // Return the maximum of both cases
    return case1 > case2 ? case1 : case2;
  }
}

void main() {
  Solution solution = Solution();
  
  // Test cases
  print(solution.rob([2, 3, 2])); // Output: 3
  print(solution.rob([1, 2, 3, 1])); // Output: 4
  print(solution.rob([1, 2, 3])); // Output: 3
}
