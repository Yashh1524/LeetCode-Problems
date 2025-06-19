public class Main {

    // static class Solution {
    // public boolean isPalindrome(String s) {
    // s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
    // int left = 0;
    // int right = s.length() - 1;

    // while (left < right) {
    // if (s.charAt(left) != s.charAt(right)) {
    // return false;
    // }
    // left++;
    // right--;
    // }
    // return true;
    // }
    // }

    static class Solution {
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;

            while (left < right) {
                char a = s.charAt(left);
                char b = s.charAt(right);

                // Convert uppercase to lowercase
                if (a >= 'A' && a <= 'Z')
                    a = (char) (a + 32);
                if (b >= 'A' && b <= 'Z')
                    b = (char) (b + 32);

                // Skip non-alphanumeric
                if (!((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) {
                    left++;
                    continue;
                }
                if (!((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) {
                    right--;
                    continue;
                }

                // Compare
                if (a != b)
                    return false;

                left++;
                right--;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + sol.isPalindrome(s1)); // true
        System.out.println();

        // Test Case 2
        String s2 = "race a car";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + sol.isPalindrome(s2)); // false
        System.out.println();

        // Test Case 3
        String s3 = " ";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + sol.isPalindrome(s3)); // true
        System.out.println();

        // Test Case 4
        String s4 = "No lemon, no melon";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + sol.isPalindrome(s4)); // true
        System.out.println();

        // Test Case 5
        String s5 = "12321";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + sol.isPalindrome(s5)); // true
        System.out.println();
    }
}
