import java.util.Arrays;

public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(minDiff, nums[n - 4 + i] - nums[i]);
        }

        return minDiff;
    }
}
