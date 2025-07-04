import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        int[] nums2 = { 0, 1, 1 };
        int[] nums3 = { 0, 0, 0 };

        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.threeSum(nums1));

        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.threeSum(nums2));

        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.threeSum(nums3));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -nums[i];
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return res;
    }
}

// class Solution {
// public List<List<Integer>> threeSum(int[] nums) {
// Map<Integer, Integer> freq = new HashMap<>();
// Set<List<Integer>> res = new HashSet<>();

// for (int x : nums) {
// freq.put(x, freq.getOrDefault(x, 0) + 1);
// }

// if (freq.getOrDefault(0, 0) >= 3) {
// res.add(Arrays.asList(0, 0, 0));
// }

// List<Integer> neg = new ArrayList<>();
// List<Integer> pos = new ArrayList<>();

// for (int x : freq.keySet()) {
// if (x < 0) neg.add(x);
// else if (x > 0) pos.add(x);
// }

// for (int i : neg) {
// for (int j : pos) {
// int k = -i - j;
// if (freq.containsKey(k)) {
// if ((k == i || k == j) && freq.get(k) < 2) continue;
// if (k == i && k == j && freq.get(k) < 3) continue;
// List<Integer> triplet = Arrays.asList(i, j, k);
// Collections.sort(triplet);
// res.add(triplet);
// }
// }
// }

// for (int x : freq.keySet()) {
// if (freq.get(x) >= 2) {
// int y = -2 * x;
// if (y != x && freq.containsKey(y)) {
// List<Integer> triplet = Arrays.asList(x, x, y);
// Collections.sort(triplet);
// res.add(triplet);
// }
// }
// }

// return new ArrayList<>(res);
// }
// }
