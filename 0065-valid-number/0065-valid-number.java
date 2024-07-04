class Solution {
    public boolean isNumber(String s) {
        // Define the regular expression pattern for a valid number
        String pattern = "^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][+-]?\\d+)?$";
        return s.matches(pattern);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.isNumber("0"));          // true
        System.out.println(solution.isNumber("e"));          // false
        System.out.println(solution.isNumber("."));          // false
        System.out.println(solution.isNumber("2"));          // true
        System.out.println(solution.isNumber("0089"));       // true
        System.out.println(solution.isNumber("-0.1"));       // true
        System.out.println(solution.isNumber("+3.14"));      // true
        System.out.println(solution.isNumber("4."));         // true
        System.out.println(solution.isNumber("-.9"));        // true
        System.out.println(solution.isNumber("2e10"));       // true
        System.out.println(solution.isNumber("-90E3"));      // true
        System.out.println(solution.isNumber("3e+7"));       // true
        System.out.println(solution.isNumber("+6e-1"));      // true
        System.out.println(solution.isNumber("53.5e93"));    // true
        System.out.println(solution.isNumber("-123.456e789"));// true
        System.out.println(solution.isNumber("abc"));        // false
        System.out.println(solution.isNumber("1a"));         // false
        System.out.println(solution.isNumber("1e"));         // false
        System.out.println(solution.isNumber("e3"));         // false
        System.out.println(solution.isNumber("99e2.5"));     // false
        System.out.println(solution.isNumber("--6"));        // false
        System.out.println(solution.isNumber("-+3"));        // false
        System.out.println(solution.isNumber("95a54e53"));   // false
    }
}
