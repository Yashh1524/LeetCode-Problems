class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // store possible majority element
        int count = 0;           // count for the candidate

        for (int num : nums) {
            if (count == 0) {    // reset candidate if count is 0
                candidate = num;
            }
            // increase if same, decrease if different
            count += (num == candidate) ? 1 : -1;
        }

        return candidate; // final candidate is the majority element
    }
}
