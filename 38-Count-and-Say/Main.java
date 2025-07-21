class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = buildNext(res);
        }
        return res;
    }

    private String buildNext(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count).append(s.charAt(s.length() - 1));
        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 1;
        System.out.println("countAndSay(" + n1 + ") = " + solution.countAndSay(n1));
        // Output: "1"

        // Test Case 2
        int n2 = 4;
        System.out.println("countAndSay(" + n2 + ") = " + solution.countAndSay(n2));
        // Output: "1211"

        // Test Case 3
        int n3 = 5;
        System.out.println("countAndSay(" + n3 + ") = " + solution.countAndSay(n3));
        // Output: "111221"

        // Test Case 4
        int n4 = 6;
        System.out.println("countAndSay(" + n4 + ") = " + solution.countAndSay(n4));
        // Output: "312211"

        // Test Case 5
        int n5 = 10;
        System.out.println("countAndSay(" + n5 + ") = " + solution.countAndSay(n5));
        // Output: "13211311123113112211"
    }
}
