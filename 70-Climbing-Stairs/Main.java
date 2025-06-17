public class Main {

    static class Solution {
        public int climbStairs(int n) {
            if (n <= 3)
                return n;
            int prev1 = 3;
            int prev2 = 2;
            int cur = 0;
            for (int i = 3; i < n; i++) {
                cur = prev1 + prev2;
                prev2 = prev1;
                prev1 = cur;
            }
            return cur;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = { 1, 2, 3, 4, 5, 10, 20, 45 };

        for (int n : testCases) {
            int result = solution.climbStairs(n);
            System.out.println("Input: n = " + n);
            System.out.println("Output: " + result);
            System.out.println("------------------------");
        }
    }
}
