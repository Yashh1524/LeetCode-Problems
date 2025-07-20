import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            int rightWindowStart = i + 1;
            if (nums[i] >= nums[rightWindowStart]) continue;

            int j = binarySearchForLowestGT(nums, nums[i], rightWindowStart);
            swap(nums, i, j);
            reverse(nums, rightWindowStart);
            return;
        }
        reverse(nums, 0);
    }

    private static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int binarySearchForLowestGT(int[] arr, int lessTarget, int start) {
        int result = -1;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > lessTarget) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        while (result < arr.length - 1 && arr[result + 1] > lessTarget) {
            result++;
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] test1 = {1, 2, 3};
        solution.nextPermutation(test1);
        System.out.println("Output 1: " + Arrays.toString(test1)); // Expected: [1, 3, 2]

        // Test Case 2
        int[] test2 = {3, 2, 1};
        solution.nextPermutation(test2);
        System.out.println("Output 2: " + Arrays.toString(test2)); // Expected: [1, 2, 3]

        // Test Case 3
        int[] test3 = {1, 1, 5};
        solution.nextPermutation(test3);
        System.out.println("Output 3: " + Arrays.toString(test3)); // Expected: [1, 5, 1]

        // Bonus Test Case 4
        int[] test4 = {2, 3, 1};
        solution.nextPermutation(test4);
        System.out.println("Output 4: " + Arrays.toString(test4)); // Expected: [3, 1, 2]
    }
}
