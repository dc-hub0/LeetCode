import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 parts in current and we've used up all characters in s
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        
        // If we've already got 4 parts but haven't used up all characters, return
        if (current.size() == 4 || start == s.length()) {
            return;
        }
        
        // Explore different segmentations of the string
        for (int i = start; i < Math.min(start + 3, s.length()); i++) {
            String segment = s.substring(start, i + 1);
            
            // Skip segments with leading zeros unless it's "0"
            if (segment.length() > 1 && segment.startsWith("0")) {
                continue;
            }
            
            // Check if the segment is a valid IP part (0-255)
            int num = Integer.parseInt(segment);
            if (num >= 0 && num <= 255) {
                current.add(segment);
                backtrack(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
