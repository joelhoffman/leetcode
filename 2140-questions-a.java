class Solution {
    long [] points;
    public long mostPoints(int[][] questions) {
        points = new long[questions.length];
        Arrays.fill(points, -1);
        return mostPoints(questions, 0);
    }

    private long mostPoints(int[][] questions, int i) {
        if (i >= questions.length) { 
            return 0;
        }
        if (points[i] == -1) {
            long solve = questions[i][0] + mostPoints(questions, i + questions[i][1] + 1);
            long skip = mostPoints(questions, i + 1);
            points[i] = solve > skip ? solve : skip;
        }
        return points[i];
    }
}
