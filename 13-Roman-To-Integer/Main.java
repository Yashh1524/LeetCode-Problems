// Main.java
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String input1 = "III";
        System.out.println("Input: " + input1 + " -> Output: " + sol.romanToInt(input1));  // 3

        // Test Case 2
        String input2 = "LVIII";
        System.out.println("Input: " + input2 + " -> Output: " + sol.romanToInt(input2));  // 58

        // Test Case 3
        String input3 = "MCMXCIV";
        System.out.println("Input: " + input3 + " -> Output: " + sol.romanToInt(input3));  // 1994

        // Test Case 4
        String input4 = "IX";
        System.out.println("Input: " + input4 + " -> Output: " + sol.romanToInt(input4));  // 9

        // Test Case 5
        String input5 = "CDXLIV";
        System.out.println("Input: " + input5 + " -> Output: " + sol.romanToInt(input5));  // 444
    }
}
