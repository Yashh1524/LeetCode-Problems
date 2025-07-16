public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Max Area (Expected 49): " + solution.maxArea(height1));

        // Test Case 2
        int[] height2 = { 1, 1 };
        System.out.println("Max Area (Expected 1): " + solution.maxArea(height2));

        // Test Case 3
        int[] height3 = { 4, 3, 2, 1, 4 };
        System.out.println("Max Area (Expected 16): " + solution.maxArea(height3));

        // Test Case 4
        int[] height4 = { 1, 2, 1 };
        System.out.println("Max Area (Expected 2): " + solution.maxArea(height4));
    }
}

class Solution {
    public int maxArea(int[] H) {
        int ans = 0, i = 0, j = H.length - 1, res = 0;
        while (i < j) {
            if (H[i] <= H[j]) {
                res = H[i] * (j - i);
                i++;
            } else {
                res = H[j] * (j - i);
                j--;
            }
            if (res > ans)
                ans = res;
        }
        return ans;
    }
}
