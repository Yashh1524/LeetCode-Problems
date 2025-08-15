import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        System.out.println("Single Number: " + sol.singleNumber(nums1)); 
        // Expected: 3
        System.out.println("--------------");

        // Test Case 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Test Case 2: " + Arrays.toString(nums2));
        System.out.println("Single Number: " + sol.singleNumber(nums2)); 
        // Expected: 99
        System.out.println("--------------");

        // Test Case 3
        int[] nums3 = {7, 7, 7, 42};
        System.out.println("Test Case 3: " + Arrays.toString(nums3));
        System.out.println("Single Number: " + sol.singleNumber(nums3)); 
        // Expected: 42
        System.out.println("--------------");

        // Test Case 4 (Extra)
        int[] nums4 = {-5, -5, -5, -10};
        System.out.println("Test Case 4: " + Arrays.toString(nums4));
        System.out.println("Single Number: " + sol.singleNumber(nums4)); 
        // Expected: -10
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}
