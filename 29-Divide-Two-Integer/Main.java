public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int dividend1 = 10;
        int divisor1 = 3;
        System.out.println("Input: dividend = " + dividend1 + ", divisor = " + divisor1);
        System.out.println("Output: " + solution.divide(dividend1, divisor1));
        System.out.println("Expected: 3\n");

        // Test case 2
        int dividend2 = 7;
        int divisor2 = -3;
        System.out.println("Input: dividend = " + dividend2 + ", divisor = " + divisor2);
        System.out.println("Output: " + solution.divide(dividend2, divisor2));
        System.out.println("Expected: -2\n");

        // Test case 3
        int dividend3 = -2147483648; // Integer.MIN_VALUE
        int divisor3 = -1;
        System.out.println("Input: dividend = " + dividend3 + ", divisor = " + divisor3);
        System.out.println("Output: " + solution.divide(dividend3, divisor3));
        System.out.println("Expected: 2147483647 (Integer.MAX_VALUE)\n");

        // Test case 4
        int dividend4 = -2147483648;
        int divisor4 = 1;
        System.out.println("Input: dividend = " + dividend4 + ", divisor = " + divisor4);
        System.out.println("Output: " + solution.divide(dividend4, divisor4));
        System.out.println("Expected: -2147483648 (Integer.MIN_VALUE)\n");

        // Test case 5
        int dividend5 = 0;
        int divisor5 = 5;
        System.out.println("Input: dividend = " + dividend5 + ", divisor = " + divisor5);
        System.out.println("Output: " + solution.divide(dividend5, divisor5));
        System.out.println("Expected: 0\n");
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor, multiple = 1;
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
