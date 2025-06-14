public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = { 123, -123, 120, 0, 1534236469, -2147483412 };

        for (int test : testCases) {
            int reversed = solution.reverse(test);
            System.out.println("Input: " + test + " -> Reversed: " + reversed);
        }
    }
}

class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        int rev = 0;

        while (num != 0) {
            int lastDigit = num % 10;

            // Check for overflow before multiplying
            if (rev > (Integer.MAX_VALUE - lastDigit) / 10) {
                return 0;
            }

            rev = rev * 10 + lastDigit;
            num = num / 10;
        }

        return (x < 0) ? -rev : rev;
    }
}
