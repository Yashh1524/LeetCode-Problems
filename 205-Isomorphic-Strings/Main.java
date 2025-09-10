class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        // Arrays to store last seen index of mapping
        int[] mapS = new int[256]; // s -> t
        int[] mapT = new int[256]; // t -> s

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If mapping not consistent, return false
            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            // Store index+1 (to avoid confusion with default 0)
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }

        return true;
    }
}
