import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 2;
        List<Integer> result1 = solution.grayCode(n1);
        System.out.println("Gray Code for n = " + n1 + ": " + result1);

        // Test Case 2
        int n2 = 1;
        List<Integer> result2 = solution.grayCode(n2);
        System.out.println("Gray Code for n = " + n2 + ": " + result2);

        // Test Case 3
        int n3 = 3;
        List<Integer> result3 = solution.grayCode(n3);
        System.out.println("Gray Code for n = " + n3 + ": " + result3);

        // Test Case 4
        int n4 = 4;
        List<Integer> result4 = solution.grayCode(n4);
        System.out.println("Gray Code for n = " + n4 + ": " + result4);
    }
}
