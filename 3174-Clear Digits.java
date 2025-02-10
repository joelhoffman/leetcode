import java.util.regex.Pattern;

class Solution {
    public String clearDigits(String s) {
        String replaced = s;
        do {
            s = replaced;
            replaced = s.replaceFirst("\\D\\d", "");
        } while (!replaced.equals(s));

        return replaced;
    }
}
