class Solution {    
    public long putMarbles(int[] weights, int k) {
        int[] splits = new int[weights.length-1];
        for(int i = 0; i < weights.length-1; i++) {
            splits[i] = weights[i+1] + weights[i];
        }
        Arrays.sort(splits);
        long maxWeight = 0;
        long minWeight = 0;
        for (int i = 0; i < k-1; i++) {
            maxWeight += splits[splits.length-1-i];
            minWeight += splits[i];
        }
        return maxWeight - minWeight;
    }
}
