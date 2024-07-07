import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int start, int n, int k) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtrack(result, combination, i + 1, n, k);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1)); 
    }
}
