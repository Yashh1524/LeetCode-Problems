import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String digits1 = "23";
        List<String> result1 = solution.letterCombinations(digits1);
        System.out.println("Input: " + digits1 + " → Output: " + result1);

        // Test Case 2
        String digits2 = "";
        List<String> result2 = solution.letterCombinations(digits2);
        System.out.println("Input: \"" + digits2 + "\" → Output: " + result2);

        // Test Case 3
        String digits3 = "2";
        List<String> result3 = solution.letterCombinations(digits3);
        System.out.println("Input: " + digits3 + " → Output: " + result3);

        // Test Case 4
        String digits4 = "79";
        List<String> result4 = solution.letterCombinations(digits4);
        System.out.println("Input: " + digits4 + " → Output: " + result4);
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        backtrack(digits, 0, map, list, new StringBuilder());
        return list;
    }

    public void backtrack(String digits, int i, HashMap<Integer, String> map, List<String> list, StringBuilder s) {
        if (i == digits.length()) {
            list.add(s.toString());
            return;
        }

        String letters = map.get(digits.charAt(i) - '0');
        for (char l : letters.toCharArray()) {
            s.append(l);
            backtrack(digits, i + 1, map, list, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
