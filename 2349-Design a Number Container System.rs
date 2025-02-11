use std::collections::HashMap;
use std::collections::BTreeSet;

struct NumberContainers {
    left: HashMap<i32, i32>,
    right: HashMap<i32, BTreeSet<i32>>
}

impl NumberContainers {

    fn new() -> Self {
        return NumberContainers { left: HashMap::new(), right: HashMap::new() };
    }
    
    fn change(&mut self, index: i32, number: i32) {
        if let Some(i) = self.left.insert(index, number) {
            self.right.get_mut(&i).unwrap().remove(&index);
        }

        self.right.entry(number)
            .or_default()
            .insert(index);
    }
    
    fn find(&self, number: i32) -> i32 {
        let set = self.right.get(&number);
        return set.map_or(-1, |set| set.first().map_or(-1, |i| *i) );
    }
}
