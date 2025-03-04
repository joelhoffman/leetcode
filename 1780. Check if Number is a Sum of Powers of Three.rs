impl Solution {
    pub fn check_powers_of_three(n: i32) -> bool {
        let mut max_power = 4782969;
        let mut n = n;
        if n == 0 { return false; }
        while (max_power > 0 && n > 0) {
            if (n >= max_power) {
                n -= max_power;
            }
            max_power /= 3;
        }
        n == 0
    }
}
