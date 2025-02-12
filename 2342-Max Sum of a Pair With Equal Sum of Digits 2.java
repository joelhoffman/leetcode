class Solution {
    public int maximumSum(int[] nums) {
        // Max values in nums are 10⁹ so max digit sum is from 999_999_999 or 81
        int[] maxPreviouslySeenForDigitSum = new int[82];
        int result = -1;

        for (int i : nums) {
            int digitSum = 0;
            int temp = i;
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }

            int candidate = maxPreviouslySeenForDigitSum[digitSum] + i;
            if (candidate > i && candidate > result) {
                result = maxPreviouslySeenForDigitSum[digitSum] + i;
            }

            if (i > maxPreviouslySeenForDigitSum[digitSum]) {
                maxPreviouslySeenForDigitSum[digitSum] = i;
            }
        }
        return result;
    }
}
