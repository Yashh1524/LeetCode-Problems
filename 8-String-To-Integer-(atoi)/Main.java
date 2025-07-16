public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "42";
        System.out.println("Input: \"" + s1 + "\" → Output: " + solution.myAtoi(s1)); // Expected: 42

        // Test Case 2
        String s2 = "   -042";
        System.out.println("Input: \"" + s2 + "\" → Output: " + solution.myAtoi(s2)); // Expected: -42

        // Test Case 3
        String s3 = "1337c0d3";
        System.out.println("Input: \"" + s3 + "\" → Output: " + solution.myAtoi(s3)); // Expected: 1337

        // Test Case 4
        String s4 = "0-1";
        System.out.println("Input: \"" + s4 + "\" → Output: " + solution.myAtoi(s4)); // Expected: 0

        // Test Case 5
        String s5 = "words and 987";
        System.out.println("Input: \"" + s5 + "\" → Output: " + solution.myAtoi(s5)); // Expected: 0

        // Test Case 6: Very large number (overflow)
        String s6 = "91283472332";
        System.out.println("Input: \"" + s6 + "\" → Output: " + solution.myAtoi(s6)); // Expected: 2147483647

        // Test Case 7: Negative overflow
        String s7 = "-91283472332";
        System.out.println("Input: \"" + s7 + "\" → Output: " + solution.myAtoi(s7)); // Expected: -2147483648

        // Test Case 8: Empty string
        String s8 = "";
        System.out.println("Input: \"" + s8 + "\" → Output: " + solution.myAtoi(s8)); // Expected: 0

        // Test Case 9: Just sign
        String s9 = "+";
        System.out.println("Input: \"" + s9 + "\" → Output: " + solution.myAtoi(s9)); // Expected: 0
    }
}

class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Use long to handle overflow before clamping

        if (s.length() == 0) return 0;

        // Check sign
        if (s.charAt(0) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        // Convert characters to integer
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;

            res = res * 10 + (ch - '0');

            // Check for overflow
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * res);
    }
}
