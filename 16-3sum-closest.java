class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0; i < nums.length-2; i++) {
            for(int j=i+1; j < nums.length-1; j++) {
                int s = nums[i] + nums[j];
                int t = target - s;

                int o = Arrays.binarySearch(nums,j+1,nums.length,t);
                if (o >= 0) {
                    return target;
                }

                if (o >= -nums.length-1 && -o-2 > j) {
                    int d = Math.abs(nums[-o-2] - t);
                    if (d < diff) { 
                        diff = d; 
                        sum=s+nums[-o-2];
                    } 
                }
                if (o > -nums.length-1 && -o-1 > j) {
                    int d = Math.abs(nums[-o-1] - t);
                    if (d < diff) { 
                        diff = d; 
                        sum=s+nums[-o-1];
                    } 
                }
            }
        }
        return sum;
    }
}
