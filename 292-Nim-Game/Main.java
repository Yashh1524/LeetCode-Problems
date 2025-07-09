public class Main {
    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[] testCases = { 1, 2, 3, 4, 5, 7, 8, 10, 12, 15, 16 };

        for (int n : testCases) {
            boolean result = sol.canWinNim(n);
            System.out.println("n = " + n + " → Can win? " + result);
        }
    }
}
