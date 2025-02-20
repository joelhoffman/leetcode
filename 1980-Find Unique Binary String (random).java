class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> values = new HashSet();
        for (String string : nums) {
            values.add(string);
        }
        while(true) {
            char[] bytes = new char[nums.length];
            Random r = new Random();
            for (int i = 0; i < nums.length; i++) {
                bytes[i] = r.nextBoolean() ? '0' : '1';
            }
            String s = new String(bytes);
            if (!values.contains(s)) {
                return s;
            }
        }
    }
}
