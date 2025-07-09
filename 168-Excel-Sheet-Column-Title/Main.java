public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int columnNumber1 = 1;
        String expected1 = "A";
        testConvertToTitle(solution, columnNumber1, expected1);

        // Test Case 2
        int columnNumber2 = 28;
        String expected2 = "AB";
        testConvertToTitle(solution, columnNumber2, expected2);

        // Test Case 3
        int columnNumber3 = 701;
        String expected3 = "ZY";
        testConvertToTitle(solution, columnNumber3, expected3);

        // Test Case 4
        int columnNumber4 = 52;
        String expected4 = "AZ";
        testConvertToTitle(solution, columnNumber4, expected4);

        // Test Case 5
        int columnNumber5 = 2147483647;
        String expected5 = "FXSHRXW"; // Maximum 32-bit integer case
        testConvertToTitle(solution, columnNumber5, expected5);

        System.out.println("All test cases passed!");
    }

    private static void testConvertToTitle(Solution solution, int columnNumber, String expected) {
        String result = solution.convertToTitle(columnNumber);
        assert result.equals(expected)
                : "Expected \"" + expected + "\", but got \"" + result + "\" for input: " + columnNumber;
    }
}

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // adjust for 1-indexed nature
            result.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}
