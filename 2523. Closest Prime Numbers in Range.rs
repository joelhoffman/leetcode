impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        let primes: Vec<i32> = Solution::relevant_primes(left, right);

        if primes.len() < 2 {
            return vec![-1, -1];
        }

        let mut min_gap = primes[1] - primes[0];
        let mut pair = vec![primes[0], primes[1]];
        for x in 0..primes.len() - 1 {
            let gap = primes[x + 1] - primes[x];
            if gap < min_gap {
                min_gap = gap;
                pair = vec![primes[x], primes[x + 1]];
            }
            if gap == 2 {
                return pair;
            }
        }
        return pair;
    }

    pub fn relevant_primes(min: i32, max: i32) -> Vec<i32> {
        if max < 2 {
            return vec![];
        }

        let mut primes = vec![];

        if min <= 2 {
            primes.push(2);
        }

        // candidates only holds odd numbers greater than 3, so
        // if 11 is prime, the offset is (11-3)/2 = 4.
        let mut candidates: Vec<bool> = vec![true;(max/2) as usize];
        let max_sqrt = (max as f64).sqrt() as usize;
        let mut p: usize = 3;
        while p <= max_sqrt {
            // only need to check odd multiples of p
            for i in ((p*3)..=max as usize).step_by(p*2) {
                candidates[(i-3)/2] = false;
            }
            p+=2;
            while (!candidates[(p-3)/2]) {
                p+=2;
            }
        }

        primes.extend(candidates.iter()
            .enumerate()
            .filter(|c| *c.1)
            .map(|c| (c.0 * 2 + 3) as i32)
            .filter(|c| *c > 1 && *c >= min && *c <= max));

        return primes;
    }
}
