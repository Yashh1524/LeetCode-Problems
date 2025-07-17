public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Test Case 1: Expected = 2.00000, Actual = " + result1);

        // Test Case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        double result2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Test Case 2: Expected = 2.50000, Actual = " + result2);

        // Additional Test Case 3
        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        double result3 = solution.findMedianSortedArrays(nums5, nums6);
        System.out.println("Test Case 3: Expected = 0.00000, Actual = " + result3);

        // Additional Test Case 4
        int[] nums7 = {};
        int[] nums8 = {1};
        double result4 = solution.findMedianSortedArrays(nums7, nums8);
        System.out.println("Test Case 4: Expected = 1.00000, Actual = " + result4);
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            return (m1 + m2) / 2.0;
        }
    }
}
