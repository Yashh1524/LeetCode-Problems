import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int m1 = 3, n1 = 7;
        System.out.println("Input: m = " + m1 + ", n = " + n1);
        System.out.println("Output: " + solution.uniquePaths(m1, n1)); // Expected 28
        System.out.println();

        // Test Case 2
        int m2 = 3, n2 = 2;
        System.out.println("Input: m = " + m2 + ", n = " + n2);
        System.out.println("Output: " + solution.uniquePaths(m2, n2)); // Expected 3
        System.out.println();

        // Test Case 3
        int m3 = 1, n3 = 5;
        System.out.println("Input: m = " + m3 + ", n = " + n3);
        System.out.println("Output: " + solution.uniquePaths(m3, n3)); // Expected 1
        System.out.println();

        // Test Case 4
        int m4 = 5, n4 = 5;
        System.out.println("Input: m = " + m4 + ", n = " + n4);
        System.out.println("Output: " + solution.uniquePaths(m4, n4)); // Expected 70
        System.out.println();

        // Test Case 5 (edge case)
        int m5 = 1, n5 = 1;
        System.out.println("Input: m = " + m5 + ", n = " + n5);
        System.out.println("Output: " + solution.uniquePaths(m5, n5)); // Expected 1
        System.out.println();
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[] aboveRow = new int[n];
        Arrays.fill(aboveRow, 1);

        for (int row = 1; row < m; row++) {
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1);
            for (int col = 1; col < n; col++) {
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            aboveRow = currentRow;
        }

        return aboveRow[n - 1];        
    }
}
