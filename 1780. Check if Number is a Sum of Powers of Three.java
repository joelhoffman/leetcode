class Solution {
    int[] powersOfThree = new int[] { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049,
    177147,531441,1594323,4782969,14348907,43046721,129140163,387420489,1162261467};
    public boolean checkPowersOfThree(int n) {
        if (0 == n) {
            return false;
        }
        for (int i = powersOfThree.length-1; i >= 0; i--) {
            if (n >= powersOfThree[i]) {
                n -= powersOfThree[i];
            }
        }
        return 0 == n;
    }
}
