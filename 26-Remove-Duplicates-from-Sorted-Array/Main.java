import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int[] expected1 = {1, 2};
        testRemoveDuplicates(solution, nums1, expected1);

        // Test Case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expected2 = {0, 1, 2, 3, 4};
        testRemoveDuplicates(solution, nums2, expected2);

        // Additional Test Case
        int[] nums3 = {1, 2, 2, 2, 3, 4, 5, 5};
        int[] expected3 = {1, 2, 3, 4, 5};
        testRemoveDuplicates(solution, nums3, expected3);

        System.out.println("All test cases passed!");
    }

    private static void testRemoveDuplicates(Solution solution, int[] nums, int[] expectedNums) {
        int k = solution.removeDuplicates(nums);

        assert k == expectedNums.length : "Expected length " + expectedNums.length + " but got " + k;

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i] : "Mismatch at index " + i + ": expected " + expectedNums[i] + " but got " + nums[i];
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> s = new LinkedHashSet<>(); // Preserves order of first occurrence
        for (int val : nums) {
            s.add(val);
        }

        int k = s.size();
        int j = 0;

        for (int val : s) {
            nums[j++] = val;
        }

        return k;
    }
}
