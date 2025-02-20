class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] bytes = new char[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bytes[i] = nums[i].charAt(i) == '1' ? '0' : '1';
        }
        return new String(bytes);
    }
}
