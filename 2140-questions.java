class Solution {
    long [] points;
    public long mostPoints(int[][] questions) {
        points = new long[questions.length];
        points[questions.length-1] = questions[questions.length-1][0];
        for(int i = questions.length-2; i >= 0; i--) {
            int solveIndex = questions[i][1] + i + 1;
            long skip = points[i+1];
            long solve = questions[i][0] + (solveIndex < questions.length ? points[solveIndex] : 0);

            points[i] = solve > skip ? solve : skip;
        }
        return points[0];
    }
}
