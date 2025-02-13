use std::cmp;
use std::collections::BinaryHeap;
impl Solution {
    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
        let mut sorted = BinaryHeap::<cmp::Reverse<u64>>::new();
        nums.into_iter().for_each(|n| sorted.push(cmp::Reverse(n as u64)));
        
        let mval = k as u64;

        let mut n = 0;
        loop {
            let m1 = sorted.pop().unwrap().0;
            if (m1 >= mval) {
                break;
            }
            let m2 = sorted.pop().unwrap().0;

            let val = m1 * 2 + m2;

            sorted.push(cmp::Reverse(val));
            n+=1;
        }

        return n;
    }
}
