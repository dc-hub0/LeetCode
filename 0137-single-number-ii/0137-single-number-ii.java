public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
    
            twos |= ones & num;
      
            ones ^= num;
        
            int common_bit_mask = ~(ones & twos);
            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }

        return ones;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums1)); 

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(solution.singleNumber(nums2)); 
    }
}
