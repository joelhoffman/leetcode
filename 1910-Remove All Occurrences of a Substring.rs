impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        let mut result = s;
        loop {
            let altered = result.replacen(&part,"",1);
            if (result == altered) {
                return altered;
            }
            result = altered;
        }
        return result;
    }
}
