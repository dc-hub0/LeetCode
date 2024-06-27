import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> combination, List<List<Integer>> result) {
        if (remaining < 0) {
            return; // if remaining is less than 0, no valid combination
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(combination)); // found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, combination, result); // not i + 1 because we can reuse same elements
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(solution.combinationSum(candidates1, target1)); // Output: [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(solution.combinationSum(candidates2, target2)); // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(solution.combinationSum(candidates3, target3)); // Output: []
    }
}
