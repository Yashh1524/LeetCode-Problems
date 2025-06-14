import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer to end of nums1's valid elements
        int p2 = n - 1; // Pointer to end of nums2
        int pMerge = m + n - 1; // Pointer to the end of nums1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge--] = nums1[p1--];
            } else {
                nums1[pMerge--] = nums2[p2--];
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1_1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2_1 = { 2, 5, 6 };
        sol.merge(nums1_1, 3, nums2_1, 3);
        System.out.println("Output 1: " + Arrays.toString(nums1_1)); // [1, 2, 2, 3, 5, 6]

        // Example 2
        int[] nums1_2 = { 1 };
        int[] nums2_2 = {};
        sol.merge(nums1_2, 1, nums2_2, 0);
        System.out.println("Output 2: " + Arrays.toString(nums1_2)); // [1]

        // Example 3
        int[] nums1_3 = { 0 };
        int[] nums2_3 = { 1 };
        sol.merge(nums1_3, 0, nums2_3, 1);
        System.out.println("Output 3: " + Arrays.toString(nums1_3)); // [1]
    }
}
