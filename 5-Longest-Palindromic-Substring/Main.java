public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "babad";
        String expected1a = "bab";
        String expected1b = "aba";
        testLongestPalindrome(solution, s1, expected1a, expected1b);

        // Test Case 2
        String s2 = "cbbd";
        String expected2 = "bb";
        testLongestPalindrome(solution, s2, expected2);

        // Test Case 3
        String s3 = "a";
        String expected3 = "a";
        testLongestPalindrome(solution, s3, expected3);

        // Test Case 4
        String s4 = "ac";
        String expected4a = "a";
        String expected4b = "c";
        testLongestPalindrome(solution, s4, expected4a, expected4b);

        // Test Case 5
        String s5 = "racecar";
        String expected5 = "racecar";
        testLongestPalindrome(solution, s5, expected5);

        System.out.println("All test cases passed!");
    }

    private static void testLongestPalindrome(Solution solution, String input, String... expectedOptions) {
        String result = solution.longestPalindrome(input);
        boolean matched = false;
        for (String expected : expectedOptions) {
            if (result.equals(expected)) {
                matched = true;
                break;
            }
        }
        assert matched : "Expected one of " + String.join(" / ", expectedOptions) + ", but got " + result
                + " for input: " + input;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int max_len = Math.max(odd, even);

            if (max_len > end - start) {
                start = i - (max_len - 1) / 2;
                end = i + max_len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
