import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = { -1, 2, 1, -4 };
        int target1 = 1;
        System.out.println("Closest Sum (Expected 2): " + solution.threeSumClosest(nums1, target1));

        // Test Case 2
        int[] nums2 = { 0, 0, 0 };
        int target2 = 1;
        System.out.println("Closest Sum (Expected 0): " + solution.threeSumClosest(nums2, target2));

        // Test Case 3
        int[] nums3 = { 1, 1, 1, 0 };
        int target3 = -100;
        System.out.println("Closest Sum (Expected 2): " + solution.threeSumClosest(nums3, target3));

        // Test Case 4
        int[] nums4 = { 1, 2, 5, 10, 11 };
        int target4 = 12;
        System.out.println("Closest Sum (Expected 13): " + solution.threeSumClosest(nums4, target4));
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2]; // Initial guess

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) {
                    return target; // exact match
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
