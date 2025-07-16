public class Main {
    static class Solution {
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < buy) {
                    buy = prices[i];
                } else if (prices[i] - buy > profit) {
                    profit = prices[i] - buy;
                }
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int[][] testCases = {
                { 7, 1, 5, 3, 6, 4 }, // Expected: 5
                { 7, 6, 4, 3, 1 }, // Expected: 0
                { 1, 2, 3, 4, 5 }, // Expected: 4
                { 3, 2, 6, 1, 3 }, // Expected: 4
                { 2, 4, 1 }, // Expected: 2
                { 2 }, // Expected: 0 (only 1 day)
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            int result = sol.maxProfit(prices);
            System.out.print("Test Case " + (i + 1) + ": prices = ");
            printArray(prices);
            System.out.println(" → Max Profit = " + result + "\n");
        }
    }

    // Helper method to print arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
}
