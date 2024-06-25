import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
 
                total += currentValue;
            }

            prevValue = currentValue;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution converter = new Solution();
        System.out.println(converter.romanToInt("III")); 
        System.out.println(converter.romanToInt("LVIII")); 
        System.out.println(converter.romanToInt("MCMXCIV")); 
    }
}
