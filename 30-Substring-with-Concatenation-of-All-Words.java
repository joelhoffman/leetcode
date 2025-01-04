class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordSet = new HashMap<>();

        for(String w : words) {
            Integer n = wordSet.get(w);
            wordSet.put(w, null == n ? 1 : n+1);
        }

        int w_l = words[0].length();
        int c_l = words.length * w_l;

        List<Integer> offsets = new ArrayList<>();

        for (int offset=0; offset < w_l; offset++) {
            Map<String, Integer> ws = new HashMap<>();
            LinkedList<String> wordWindow = new LinkedList<>();

            for (int i = offset; i < offset + c_l - w_l && i < s.length() - w_l; i += w_l) {
                String word = s.substring(i, i + w_l);
                int c = ws.getOrDefault(word,0);
                ws.put(word,c+1);
                wordWindow.add(word);
            }

            for (int i = offset + c_l - w_l; i <= s.length() - w_l; i+=w_l) {
                String word = s.substring(i, i + w_l);
                Integer count = ws.getOrDefault(word,0);
                ws.put(word, count + 1);
                wordWindow.add(word);
                if (ws.equals(wordSet)) {
                    offsets.add(i + w_l - c_l);
                }
                String lastWord = wordWindow.removeFirst();
                count = ws.get(lastWord);
                if (1 == count) {
                    ws.remove(lastWord);
                } else {
                    ws.put(lastWord, count-1);
                }
            }
        }

        return offsets;
    }
}
