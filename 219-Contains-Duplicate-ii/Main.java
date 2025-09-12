class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // map value -> last index seen
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (lastIndex.containsKey(val)) {
                int prev = lastIndex.get(val);
                // if previous index within k distance, return true
                if (i - prev <= k) return true;
            }
            // update last seen index for this value
            lastIndex.put(val, i);
        }

        return false;
    }
}
