public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String[] strs1 = { "flower", "flow", "flight" };
        String expected1 = "fl";
        testLongestCommonPrefix(solution, strs1, expected1);

        // Test Case 2
        String[] strs2 = { "dog", "racecar", "car" };
        String expected2 = "";
        testLongestCommonPrefix(solution, strs2, expected2);

        // Test Case 3
        String[] strs3 = { "interspecies", "interstellar", "interstate" };
        String expected3 = "inters";
        testLongestCommonPrefix(solution, strs3, expected3);

        // Test Case 4
        String[] strs4 = { "throne", "throne" };
        String expected4 = "throne";
        testLongestCommonPrefix(solution, strs4, expected4);

        // Test Case 5
        String[] strs5 = { "a" };
        String expected5 = "a";
        testLongestCommonPrefix(solution, strs5, expected5);

        // Test Case 6
        String[] strs6 = { "", "b" };
        String expected6 = "";
        testLongestCommonPrefix(solution, strs6, expected6);

        System.out.println("All test cases passed!");
    }

    private static void testLongestCommonPrefix(Solution solution, String[] strs, String expected) {
        String result = solution.longestCommonPrefix(strs);
        assert result.equals(expected) : "Expected \"" + expected + "\", but got \"" + result + "\"";
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
