public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String a1 = "11", b1 = "1";
        String expected1 = "100";
        testAddBinary(solution, a1, b1, expected1);

        // Test Case 2
        String a2 = "1010", b2 = "1011";
        String expected2 = "10101";
        testAddBinary(solution, a2, b2, expected2);

        // Test Case 3
        String a3 = "0", b3 = "0";
        String expected3 = "0";
        testAddBinary(solution, a3, b3, expected3);

        // Test Case 4
        String a4 = "1", b4 = "111";
        String expected4 = "1000";
        testAddBinary(solution, a4, b4, expected4);

        // Test Case 5
        String a5 = "1111", b5 = "1111";
        String expected5 = "11110";
        testAddBinary(solution, a5, b5, expected5);

        System.out.println("All test cases passed!");
    }

    private static void testAddBinary(Solution solution, String a, String b, String expected) {
        String result = solution.addBinary(a, b);
        assert result.equals(expected)
                : "Expected " + expected + ", but got " + result + " for inputs a: " + a + ", b: " + b;
    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';

            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}
