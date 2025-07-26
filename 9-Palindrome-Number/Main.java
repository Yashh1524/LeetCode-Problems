public class Main {

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int reverse = 0;
            int xcopy = x;

            while (x > 0) {
                reverse = (reverse * 10) + (x % 10);
                x /= 10;
            }

            return reverse == xcopy;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testCases = {121, -121, 10, 0, 12321, 1234321, 1000021};
        boolean[] expectedResults = {true, false, false, true, true, true, false};

        for (int i = 0; i < testCases.length; i++) {
            int input = testCases[i];
            boolean expected = expectedResults[i];
            boolean result = solution.isPalindrome(input);

            System.out.printf("Input: %d | Output: %b | Expected: %b | %s\n",
                    input, result, expected, result == expected ? "PASS" : "FAIL");
        }
    }
}
