import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s1 = "()";
        printResult(s1, sol.isValid(s1)); // Expected: true

        // Test Case 2
        String s2 = "()[]{}";
        printResult(s2, sol.isValid(s2)); // Expected: true

        // Test Case 3
        String s3 = "(]";
        printResult(s3, sol.isValid(s3)); // Expected: false

        // Test Case 4
        String s4 = "([])";
        printResult(s4, sol.isValid(s4)); // Expected: true

        // Test Case 5
        String s5 = "([)]";
        printResult(s5, sol.isValid(s5)); // Expected: false

        // Test Case 6 - Edge case: only one bracket
        String s6 = "(";
        printResult(s6, sol.isValid(s6)); // Expected: false

        // Test Case 7 - Nested brackets
        String s7 = "{[()()]}";
        printResult(s7, sol.isValid(s7)); // Expected: true
    }

    public static void printResult(String input, boolean result) {
        System.out.println("Input: \"" + input + "\" => Output: " + result);
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
