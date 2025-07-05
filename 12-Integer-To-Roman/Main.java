import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testInputs = { 3749, 58, 1994, 4, 9, 40, 90, 400, 900, 3999, 1 };

        for (int num : testInputs) {
            String roman = solution.intToRoman(num);
            System.out.println("Input: " + num + " -> Roman Numeral: " + roman);
        }
    }
}

class Solution {
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanNumerals = {
                "M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
