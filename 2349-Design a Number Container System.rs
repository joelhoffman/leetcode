use std::collections::HashMap;
use std::collections::BTreeSet;

struct NumberContainers {
    left: HashMap<i32, i32>,
    right: HashMap<i32, BTreeSet<i32>>
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumberContainers {

    fn new() -> Self {
        return NumberContainers { left: HashMap::new(), right: HashMap::new() };
    }
    
    fn change(&mut self, index: i32, number: i32) {
        let prev = self.left.insert(index, number);
        if let Some(i) = prev {
            let mut rev = self.right.get_mut(&i).unwrap();
            rev.remove(&index);
        }

        let mut maybe_rev = self.right.get_mut(&number);

        match maybe_rev {
            Some(rev) => {
                rev.insert(index);
            },
            _ => {
                let mut rev = BTreeSet::new();
                rev.insert(index);
                self.right.insert(number, rev);
            }
        };
    }
    
    fn find(&self, number: i32) -> i32 {
        let set = self.right.get(&number);
        return set.map_or(-1, |set| set.first().map_or(-1, |i| *i) );
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * let obj = NumberContainers::new();
 * obj.change(index, number);
 * let ret_2: i32 = obj.find(number);
 */
