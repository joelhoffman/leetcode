class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int nless=0;
        int ngreater=nums.length;
        int[] less = new int[nums.length];
        for (int i : nums) {
            if (i < pivot) { less[nless++] = i; }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > pivot) { less[--ngreater] = nums[i]; }
        }
        for (int i = nless; i < ngreater; i++) {
            less[i] = pivot;
        }
        return less;
    }
}
