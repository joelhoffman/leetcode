class Solution {
    public String smallestNumber(String pattern) {
        return smallestNumber("", 0, pattern, List.of("1","2","3","4","5","6","7","8","9"));
    }

    public String smallestNumber(String prev, int cmp, String pattern, List<String> digits) {
        if (pattern.isEmpty()) {
            return digits.stream()
                .filter(digit -> prev.isBlank() || digit.compareTo(prev) > 0 == cmp > 0)
                .findFirst().orElse(null);
        }
        else if (digits.isEmpty() || pattern.isEmpty()) {
            throw new IllegalStateException();
        }
        String minimum = null;
        String upOrDown = pattern.substring(0,1);
        List<String> otherDigits = new ArrayList<>(digits.subList(1, digits.size()));
        String restOfPattern = pattern.substring(1);
        int direction = upOrDown.equals("I") ? 1 : -1;
        
        for (int i = 0; i < digits.size(); i++) {
            String digit = digits.get(i);
            int test = digit.compareTo(prev);
            if (prev.isBlank() || (test > 0) == (cmp > 0)) { 
                String candidate = smallestNumber(digit, direction, restOfPattern, otherDigits);
                if (null != candidate) {
                    candidate = digit + candidate;
                    if (null == minimum || candidate.compareTo(minimum) < 0) {
                        minimum = candidate;
                    }
                }
            }
            if (i < otherDigits.size()) {
                otherDigits.set(i, digit);
            }
        }
        return minimum;
    }
}
