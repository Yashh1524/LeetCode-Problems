import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int rowIndex1 = 3;
        List<Integer> expected1 = Arrays.asList(1, 3, 3, 1);
        testGetRow(solution, rowIndex1, expected1);

        // Test Case 2
        int rowIndex2 = 0;
        List<Integer> expected2 = Arrays.asList(1);
        testGetRow(solution, rowIndex2, expected2);

        // Test Case 3
        int rowIndex3 = 1;
        List<Integer> expected3 = Arrays.asList(1, 1);
        testGetRow(solution, rowIndex3, expected3);

        // Test Case 4
        int rowIndex4 = 5;
        List<Integer> expected4 = Arrays.asList(1, 5, 10, 10, 5, 1);
        testGetRow(solution, rowIndex4, expected4);

        System.out.println("All test cases passed!");
    }

    private static void testGetRow(Solution solution, int rowIndex, List<Integer> expected) {
        List<Integer> result = solution.getRow(rowIndex);
        assert result.equals(expected) : "Expected " + expected + ", but got " + result + " for rowIndex = " + rowIndex;
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 1; j < row.size(); j++) {
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = newRow;
        }

        return row;
    }
}
