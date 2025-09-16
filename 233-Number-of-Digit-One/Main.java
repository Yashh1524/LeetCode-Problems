class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        long factor = 1; // 1, 10, 100 ...
        int count = 0;

        while (factor <= n) {
            long higher = n / (factor * 10);
            long curr = (n / factor) % 10;
            long lower = n % factor;

            if (curr == 0) {
                count += higher * factor;
            } else if (curr == 1) {
                count += higher * factor + lower + 1;
            } else {
                count += (higher + 1) * factor;
            }

            factor *= 10;
        }

        return count;
    }
}
