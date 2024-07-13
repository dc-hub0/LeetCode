class Solution {
    public boolean isPalindrome(String s) {
        // Use a StringBuilder to efficiently build the filtered string
        StringBuilder filtered = new StringBuilder();
        
        // Convert all characters to lowercase and keep only alphanumeric characters
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }
        
        // Convert the StringBuilder to a String
        String filteredStr = filtered.toString();
        
        // Use two pointers to check if the string is a palindrome
        int left = 0;
        int right = filteredStr.length() - 1;
        
        while (left < right) {
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        
        return true; // It is a palindrome
    }
}
