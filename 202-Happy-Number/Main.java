class Solution {
    public boolean isHappy(int n) {
        int slow = n;              // slow pointer (moves 1 step)
        int fast = getNext(n);     // fast pointer (moves 2 steps)

        // loop until fast becomes 1 (happy number) or cycle detected
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);                  // move 1 step
            fast = getNext(getNext(fast));         // move 2 steps
        }

        return fast == 1;          // if fast reached 1 → happy number
    }

    private int getNext(int n) {
        int sum = 0;
        // calculate sum of squares of digits
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
