import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        
        backtrack(result, phoneMap, digits, 0, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, int index, StringBuilder path) {
       
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        
        String possibleLetters = phoneMap.get(digits.charAt(index));
        
        
        for (char letter : possibleLetters.toCharArray()) {
            path.append(letter); 
            backtrack(result, phoneMap, digits, index + 1, path); 
            path.deleteCharAt(path.length() - 1); 
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String digits1 = "23";
        System.out.println(solution.letterCombinations(digits1));
        
        // Example 2
        String digits2 = "";
        System.out.println(solution.letterCombinations(digits2)); // Output: []
        
        // Example 3
        String digits3 = "2";
        System.out.println(solution.letterCombinations(digits3)); // Output: ["a","b","c"]
    }
}
