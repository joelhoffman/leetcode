class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        String longest = s.substring(0,1);
        int l=0;
        while (l < s.length()-1) {
            int r = l;
            while (r < s.length() - 1 && s.charAt(r+1) == s.charAt(l)) {
                r++;
            }
            int ll = l;
            while (l > 0 && r < s.length()-1 && s.charAt(l-1) == s.charAt(r+1)) {
                l--;
                r++;
            }
            if (r-l+1 > longest.length()) {
                longest=s.substring(l,r+1);
                if (s.length()-r == l+1) {
                    return longest;
                }
            }
            l = ll+1;
            r=l;
        }
        return longest;
    }
}
