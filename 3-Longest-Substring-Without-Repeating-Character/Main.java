import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "abcabcbb";
        int expected1 = 3;
        testLengthOfLongestSubstring(solution, s1, expected1);

        // Test Case 2
        String s2 = "bbbbb";
        int expected2 = 1;
        testLengthOfLongestSubstring(solution, s2, expected2);

        // Test Case 3
        String s3 = "pwwkew";
        int expected3 = 3;
        testLengthOfLongestSubstring(solution, s3, expected3);

        // Test Case 4: Empty string
        String s4 = "";
        int expected4 = 0;
        testLengthOfLongestSubstring(solution, s4, expected4);

        // Test Case 5: All unique characters
        String s5 = "abcdefg";
        int expected5 = 7;
        testLengthOfLongestSubstring(solution, s5, expected5);

        // Test Case 6: Longest substring at the end
        String s6 = "abcbdeafg";
        int expected6 = 7; // "cbdeafg"
        testLengthOfLongestSubstring(solution, s6, expected6);

        System.out.println("All test cases passed!");
    }

    private static void testLengthOfLongestSubstring(Solution solution, String s, int expected) {
        int result = solution.lengthOfLongestSubstring(s);
        assert result == expected : "Expected " + expected + ", but got " + result + " for input: " + s;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            if (charMap.containsKey(current) && charMap.get(current) >= left) {
                left = charMap.get(current) + 1;
            }
            charMap.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
