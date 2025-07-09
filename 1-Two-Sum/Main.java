import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pairIdx.containsKey(target - num)) {
                return new int[] { pairIdx.get(target - num), i }; // Ensure [index of complement, current index]
            }
            pairIdx.put(num, i);
        }
        return new int[] {};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Output 1: " + Arrays.toString(sol.twoSum(nums1, target1))); // [0, 1]

        // Example 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("Output 2: " + Arrays.toString(sol.twoSum(nums2, target2))); // [1, 2]

        // Example 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("Output 3: " + Arrays.toString(sol.twoSum(nums3, target3))); // [0, 1]

        // Additional Test Case
        int[] nums4 = { 1, 5, 3, 7 };
        int target4 = 10;
        System.out.println("Output 4: " + Arrays.toString(sol.twoSum(nums4, target4))); // [1, 3]
    }
}
