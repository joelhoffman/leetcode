class Solution {
    public String getHappyString(int n, int k) {
        String h;
        if (k > 3 * (1<<(n-1))) {
            return "";
        }
        if (n == 1) {
            return k <= 3 ? "abc".substring(k-1,k) : "";
        }
        if (k > 1 << n) {
            h = "c" + getHappyString("ab", n-1, k - (1 << n));
        } else if (k > 1 << (n-1)) {
            h = "b" + getHappyString("ac", n-1, k - (1 << n-1));
        } else {
            h = "a" + getHappyString("bc", n-1, k);
        }

        if (h.length() < n) {
            return "";
        }
        return h;
    }

    private String getHappyString(String letters, int n, int k) {
        if (n <= 1) {
            return letters.length() >= k ? letters.substring(k-1,k) : "";
        }
        String letter;
        int nk;
        if (k > 1 << n) {
            letter = letters.substring(1);
            nk = k - (1 << n);
        } else if (k > 1 << (n-1)) {
            letter = letters.substring(1);
            nk = k - (1 << (n-1));
        } else {
            letter = letters.substring(0,1);
            nk = k;
        }

        return letter + getHappyString(letter.equals("a") ? "bc" : letter.equals("b") ? "ac" : "ab", n-1, nk);
    }
}
