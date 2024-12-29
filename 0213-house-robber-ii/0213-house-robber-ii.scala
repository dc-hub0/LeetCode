object Solution {
    def rob(nums: Array[Int]): Int = {
        if (nums.length == 1) return nums(0)
        if (nums.length == 2) return nums.max

        // Helper function to compute the maximum amount for linear house arrangement
        def robLinear(houses: Array[Int]): Int = {
            var prev = 0
            var curr = 0
            for (money <- houses) {
                val temp = curr
                curr = Math.max(curr, prev + money)
                prev = temp
            }
            curr
        }

        // Compute maximum for two scenarios
        val robFirstToSecondLast = robLinear(nums.slice(0, nums.length - 1))
        val robSecondToLast = robLinear(nums.slice(1, nums.length))

        Math.max(robFirstToSecondLast, robSecondToLast)
    }
}
