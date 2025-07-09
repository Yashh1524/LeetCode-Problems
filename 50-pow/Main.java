public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        double x1 = 2.00000;
        int n1 = 10;
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x1, n1, solution.myPow(x1, n1)); // 1024.00000

        // Test Case 2
        double x2 = 2.10000;
        int n2 = 3;
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x2, n2, solution.myPow(x2, n2)); // 9.26100

        // Test Case 3
        double x3 = 2.00000;
        int n3 = -2;
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x3, n3, solution.myPow(x3, n3)); // 0.25000

        // Edge Case: x = 0, n > 0
        double x4 = 0.00000;
        int n4 = 5;
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x4, n4, solution.myPow(x4, n4)); // 0.00000

        // Edge Case: x = 1, any n
        double x5 = 1.00000;
        int n5 = -100000;
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x5, n5, solution.myPow(x5, n5)); // 1.00000

        // Large Negative Exponent
        double x6 = 2.00000;
        int n6 = -2147483648; // Integer.MIN_VALUE
        System.out.printf("myPow(%.5f, %d) = %.5f\n", x6, n6, solution.myPow(x6, n6));
    }
}

class Solution {

    private double helper(double x, long n) {
        if (n == 0)
            return 1;

        double half = helper(x, n / 2);
        double result = half * half;

        if (n % 2 != 0) {
            result *= x;
        }

        return result;
    }

    public double myPow(double x, int n) {
        long N = n; // use long to avoid overflow for n == Integer.MIN_VALUE

        if (n == 0 || x == 1)
            return 1;
        if (n == 1)
            return x;
        if (x == 0)
            return 0;

        if (N < 0) {
            x = 1.0 / x;
            N = -N;
        }

        return helper(x, N);
    }
}
