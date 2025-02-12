import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityBlockingQueue<Integer>> sums = new HashMap<>();
        for (int i : nums) {
            int digitSum = 0;
            int ii = i;
            while (ii > 0) {
                digitSum += ii % 10;
                ii /= 10;
            }
            PriorityBlockingQueue<Integer> queue = sums.get(digitSum);
            if (null == queue) {
                queue = new PriorityBlockingQueue<>(1, Comparator.<Integer>naturalOrder().reversed());
                sums.put(digitSum, queue);
            }
            queue.add(i);
        }
        try {
            int maxValue = -1;
            for (Map.Entry<Integer, PriorityBlockingQueue<Integer>> e : sums.entrySet()) {
                PriorityBlockingQueue<Integer> q = e.getValue();
                if (q.size() > 1) {
                    int sum = q.take() + q.take();
                    if (sum > maxValue) {
                        maxValue = sum;
                    }
                }
            }

            return maxValue;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
