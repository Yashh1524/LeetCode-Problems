public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "PAYPALISHIRING";
        int rows1 = 3;
        System.out.println("Output (Expected: PAHNAPLSIIGYIR): " + solution.convert(s1, rows1));

        // Test Case 2
        String s2 = "PAYPALISHIRING";
        int rows2 = 4;
        System.out.println("Output (Expected: PINALSIGYAHRPI): " + solution.convert(s2, rows2));

        // Test Case 3
        String s3 = "A";
        int rows3 = 1;
        System.out.println("Output (Expected: A): " + solution.convert(s3, rows3));

        // Test Case 4
        String s4 = "AB";
        int rows4 = 1;
        System.out.println("Output (Expected: AB): " + solution.convert(s4, rows4));

        // Test Case 5
        String s5 = "HELLOZIGZAG";
        int rows5 = 5;
        System.out.println("Output: " + solution.convert(s5, rows5));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += 2 * (numRows - 1)) {
                result.append(s.charAt(j));

                // Add the diagonal character if it's not the first or last row
                int diagonalIndex = j + 2 * (numRows - 1) - 2 * i;
                if (i > 0 && i < numRows - 1 && diagonalIndex < s.length()) {
                    result.append(s.charAt(diagonalIndex));
                }
            }
        }

        return result.toString();
    }
}
