public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String previous = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();

        int count = 1;
        char say = previous.charAt(0);

        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == say) {
                count++;
            } else {
                result.append(count).append(say);
                count = 1;
                say = previous.charAt(i);
            }
        }
        
        result.append(count).append(say);

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        System.out.println(solution.countAndSay(n));  // Output: "1211"

        n = 1;
        System.out.println(solution.countAndSay(n));  // Output: "1"
    }
}
