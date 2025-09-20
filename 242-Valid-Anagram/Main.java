class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // if lengths differ, can't be anagram

        int[] count = new int[26]; // frequency array for 26 lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // increase count for s
            count[t.charAt(i) - 'a']--; // decrease count for t
        }

        for (int c : count) {
            if (c != 0) return false; // if any count not zero, not an anagram
        }

        return true; // all counts matched, it's an anagram
    }
}
