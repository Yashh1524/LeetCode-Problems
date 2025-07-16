class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = { 2, 2, 1 };
        System.out.println("Output 1: " + sol.singleNumber(nums1)); // Expected: 1

        // Example 2
        int[] nums2 = { 4, 1, 2, 1, 2 };
        System.out.println("Output 2: " + sol.singleNumber(nums2)); // Expected: 4

        // Example 3
        int[] nums3 = { 1 };
        System.out.println("Output 3: " + sol.singleNumber(nums3)); // Expected: 1

        // Additional Test Case 1
        int[] nums4 = { 7, 3, 5, 3, 7 };
        System.out.println("Output 4: " + sol.singleNumber(nums4)); // Expected: 5

        // Additional Test Case 2 (Negative numbers)
        int[] nums5 = { -1, -1, -2 };
        System.out.println("Output 5: " + sol.singleNumber(nums5)); // Expected: -2
    }
}
