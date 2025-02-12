
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,new HashMap<>());
    }

    private boolean isMatch(String s, String p, HashMap<String,Boolean> match) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.equals("*".repeat(p.length()))) {
            return true;
        }

        String key = s.length() + ":" + p.length();
        Boolean b= match.get(key);
        if (null != b) {
            return b;
        }

        char matchChar = p.charAt(0);
        Character strChar = s.length() > 0 ? s.charAt(0) : null;
        boolean isStar = matchChar == '*';

        boolean isCharMatch = null != strChar && (matchChar == strChar || matchChar == '?');

        int endStar = 0;
        while(endStar < p.length() && p.charAt(endStar) == '*') { endStar++; }

        boolean pNullMatch = isStar && isMatch(s, p.substring(endStar), match);

        if ((null == strChar || !isCharMatch) && pNullMatch) {
            match.put(key, true);
            return true;
        }

        boolean result;
        if (isStar) {
            result = pNullMatch || (null != strChar && isMatch(s.substring(1), p.substring(endStar-1), match)); 
        } else if (null != strChar && isCharMatch) {
            int i = 0;
            while (i < s.length() && i < p.length() 
                && (s.charAt(i) == p.charAt(i) || p.charAt(i) == '?'))
                { i++; }
            result = isMatch(s.substring(i), p.substring(i), match);
        } else {
            result = false;
        }

        match.put(key, result);
        return result;
    }
}
