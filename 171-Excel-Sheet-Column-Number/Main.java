class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char ch : columnTitle.toCharArray()) {
            int value = ch - 'A' + 1;  // convert letter to number
            result = result * 26 + value; // shift left in base-26 and add value
        }

        return result;
    }
}