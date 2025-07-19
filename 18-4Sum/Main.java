import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> result1 = solution.fourSum(nums1, target1);
        System.out.println("Test Case 1 Output: " + result1);

        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        List<List<Integer>> result2 = solution.fourSum(nums2, target2);
        System.out.println("Test Case 2 Output: " + result2);

        // Additional Test Case
        int[] nums3 = {0, 0, 0, 0};
        int target3 = 0;
        List<List<Integer>> result3 = solution.fourSum(nums3, target3);
        System.out.println("Test Case 3 Output: " + result3);
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return ans;
    }
}
