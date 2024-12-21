class Solution {
    record ParenSet(int offset, int length) {};

    public int longestValidParentheses(String s) {
        Deque<Integer> openParens = new ArrayDeque<>();
        List<ParenSet> parens = new ArrayList<>();
        for(int i=0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParens.push(i);
            } else if (s.charAt(i) == ')') {
                if (openParens.isEmpty()) {
                    continue;
                } else {
                    int prev = openParens.pop();
                    int l = 1 + i - prev;
                    parens.add(new ParenSet(prev, l));
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        int maxLength = 0;
        int nextOffset = 0;
        int currentLength = 0;
        Collections.sort(parens, Comparator.comparing(a -> a.offset));
        while (!parens.isEmpty()) {
            while(!parens.isEmpty() && parens.get(0).offset < nextOffset) {
                parens.remove(0);
            }
            if (!parens.isEmpty()) {
                ParenSet next = parens.remove(0);
                if (next.offset > nextOffset) {
                    if (currentLength > maxLength) { maxLength = currentLength; }
                    currentLength = 0;
                } else {
                }
                currentLength += next.length;
                nextOffset = next.offset + next.length;
            }
        }
        if (currentLength > maxLength) { maxLength = currentLength; }
        return maxLength;
    }
}
