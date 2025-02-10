use std::collections::HashMap;
impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        let mut offsets = HashMap::new();
        for x in 0..nums.len() {
            let offset = nums[x] - (x as i32);
            match offsets.get(&offset) {
                Some(c) => offsets.insert(offset, c+1),
                _ => offsets.insert(offset, 1),
            };
        }
        let pairs: i64 = (nums.len() as i64 * (nums.len() as i64 -1)) / 2;
        let good_pairs: i64 = offsets.values().map(|n| (n*(n-1))/2 ).sum();
        return pairs - good_pairs;
    }
}
