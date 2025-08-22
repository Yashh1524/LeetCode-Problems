public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 43261596;
        int result1 = solution.reverseBits(n1);
        System.out.println("Input: " + n1 + " -> Output: " + result1); 
        // Expected: 964176192

        // Test Case 2
        int n2 = 2147483644;
        int result2 = solution.reverseBits(n2);
        System.out.println("Input: " + n2 + " -> Output: " + result2); 
        // Expected: 1073741822

        // Test Case 3
        int n3 = 0;
        int result3 = solution.reverseBits(n3);
        System.out.println("Input: " + n3 + " -> Output: " + result3); 
        // Expected: 0

        // Test Case 4
        int n4 = 1;
        int result4 = solution.reverseBits(n4);
        System.out.println("Input: " + n4 + " -> Output: " + result4); 
        // Expected: 2147483648 (but prints -2147483648 due to signed int)
    }
}

class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;                 
            result = (result << 1) | bit;    
            n = n >>> 1;                     
        }
        return result;
    }
}
