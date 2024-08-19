class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0 && s.length() == 0) {
            return true;
        }

        if (p.length() == 0) {
            return false;
        }

        char matchChar = p.charAt(0);
        boolean isStar = p.length() > 1 && p.charAt(1) == '*';
        Character strChar = s.length() == 0 ? null : s.charAt(0);
        boolean isCharMatch = null != strChar && 
            (matchChar == strChar || matchChar == '.');

        if ((null == strChar || !isCharMatch) && isStar) {
            return isMatch(s, p.substring(2));
        }


        if (isStar) {
            if ((isCharMatch && isMatch(s.substring(1), p)) 
                || isMatch(s, p.substring(2))) 
            {
                return true;
            }
        } else {
            if (null != strChar && isCharMatch) {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        return false;
    }
}
