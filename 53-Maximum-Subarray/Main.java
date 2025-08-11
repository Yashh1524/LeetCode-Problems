public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        printResult(nums1, sol.maxSubArray(nums1)); // Expected: 6

        // Test Case 2
        int[] nums2 = {1};
        printResult(nums2, sol.maxSubArray(nums2)); // Expected: 1

        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        printResult(nums3, sol.maxSubArray(nums3)); // Expected: 23

        // Test Case 4
        int[] nums4 = {-1, -2, -3, -4};
        printResult(nums4, sol.maxSubArray(nums4)); // Expected: -1

        // Test Case 5
        int[] nums5 = {2, -1, 2, 3, -9, 4, 7};
        printResult(nums5, sol.maxSubArray(nums5)); // Expected: 11
    }

    public static void printResult(int[] nums, int result) {
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("] => Output: " + result);
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
