import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 3;
        List<String> result1 = solution.generateParenthesis(n1);
        System.out.println("Input: " + n1 + " → Output: " + result1);

        // Test Case 2
        int n2 = 1;
        List<String> result2 = solution.generateParenthesis(n2);
        System.out.println("Input: " + n2 + " → Output: " + result2);

        // Test Case 3
        int n3 = 2;
        List<String> result3 = solution.generateParenthesis(n3);
        System.out.println("Input: " + n3 + " → Output: " + result3);

        // Test Case 4
        int n4 = 4;
        List<String> result4 = solution.generateParenthesis(n4);
        System.out.println("Input: " + n4 + " → Output: " + result4);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int openCount, int closeCount, int n) {
        if (openCount == n && closeCount == n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            backtrack(result, current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            backtrack(result, current + ")", openCount, closeCount + 1, n);
        }
    }
}
