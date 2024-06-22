import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        
        int count = 0;
        int prefixSum = 0;
        
        
        for (int num : nums) {
          
            prefixSum += num % 2 == 1 ? 1 : 0;
            
      
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }
            
            
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }

 
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println(sol.numberOfSubarrays(nums1, k1)); // Output: 2

        // Example 2
        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println(sol.numberOfSubarrays(nums2, k2)); // Output: 0

        // Example 3
        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println(sol.numberOfSubarrays(nums3, k3)); // Output: 16
    }
}
