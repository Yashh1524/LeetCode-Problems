public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Expected: 4, Output: " + sol.search(nums1, target1));

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Expected: -1, Output: " + sol.search(nums2, target2));

        // Test Case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Expected: -1, Output: " + sol.search(nums3, target3));

        // Test Case 4
        int[] nums4 = {6, 7, 1, 2, 3, 4, 5};
        int target4 = 4;
        System.out.println("Expected: 5, Output: " + sol.search(nums4, target4));

        // Test Case 5
        int[] nums5 = {1, 3};
        int target5 = 3;
        System.out.println("Expected: 1, Output: " + sol.search(nums5, target5));
    }
}

// Provided Solution class
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
