import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort candidates to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> combination, List<List<Integer>> result) {
        if (remaining < 0) {
            return; // If remaining is less than 0, no valid combination
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(combination)); // Found a valid combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            combination.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i + 1, combination, result); // i + 1 because each number can be used only once
            combination.remove(combination.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(solution.combinationSum2(candidates1, target1)); // Output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(solution.combinationSum2(candidates2, target2)); // Output: [[1, 2, 2], [5]]
    }
}
