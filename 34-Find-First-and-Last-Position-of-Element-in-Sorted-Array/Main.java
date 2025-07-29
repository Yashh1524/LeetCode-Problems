public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        printResult(nums1, target1, sol.searchRange(nums1, target1));  // Expected: [3, 4]

        // Test Case 2
        int[] nums2 = {5, 7, 7, 8, 8, 10};
        int target2 = 6;
        printResult(nums2, target2, sol.searchRange(nums2, target2));  // Expected: [-1, -1]

        // Test Case 3
        int[] nums3 = {};
        int target3 = 0;
        printResult(nums3, target3, sol.searchRange(nums3, target3));  // Expected: [-1, -1]

        // Test Case 4
        int[] nums4 = {1, 1, 1, 1, 1};
        int target4 = 1;
        printResult(nums4, target4, sol.searchRange(nums4, target4));  // Expected: [0, 4]
    }

    public static void printResult(int[] nums, int target, int[] result) {
        System.out.print("Input: nums = [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.print("], target = " + target);
        System.out.println(" => Output: [" + result[0] + ", " + result[1] + "]");
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);
        return ans;
    }

    static int binarySearch(int[] nums, int target, boolean findFirst) {
        int s = 0, e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target > nums[mid]) {
                s = mid + 1;
            } else if (target < nums[mid]) {
                e = mid - 1;
            } else {
                ans = mid;
                if (findFirst) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }

        return ans;
    }
}
