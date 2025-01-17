class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int x = 0;
        for (int i : derived) {
            x += i;
        }
        return x % 2 == 0;
    }
}
