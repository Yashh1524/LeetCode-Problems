public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (mid % 2 == 1)
                mid--;
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // Main method with test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                { 1, 1, 2, 3, 3, 4, 4, 8, 8 },
                { 3, 3, 7, 7, 10, 11, 11 },
                { 99 },
                { 1, 1, 2, 2, 3, 3, 4 },
                { 0, 1, 1, 2, 2, 3, 3 },
                { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 7 },
        };

        int[] expectedOutputs = {
                2,
                10,
                99,
                4,
                0,
                6,
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = sol.singleNonDuplicate(testCases[i]);
            System.out
                    .println("Test Case " + (i + 1) + ": " + (result == expectedOutputs[i] ? "✅ Passed" : "❌ Failed"));
            System.out.println("Expected: " + expectedOutputs[i] + ", Got: " + result);
        }
    }
}
