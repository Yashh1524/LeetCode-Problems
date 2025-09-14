import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int start = nums[0];   // start of current range
        int end = nums[0];     // end of current range

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // extend current range
                end = nums[i];
            } else {
                // finish current range and add to result
                res.add(formatRange(start, end));
                // start new range
                start = end = nums[i];
            }
        }

        // add the last range
        res.add(formatRange(start, end));
        return res;
    }

    // helper to format range string
    private String formatRange(int a, int b) {
        return (a == b) ? String.valueOf(a) : (a + "->" + b);
    }
}
