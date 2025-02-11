struct MedianFinder {
    vec: Vec<i32>,
}


impl MedianFinder {

    fn new() -> Self {
        return MedianFinder {
            vec: Vec::new(),
        }
    }
    
    fn add_num(&mut self, num: i32) {
        match self.vec.binary_search(&num) {
            Ok(pos) => self.vec.insert(pos, num),
            Err(pos) => self.vec.insert(pos, num),
        }
    }
    
    fn find_median(&self) -> f64 {
        if self.vec.len() == 0 {
            return 0f64;
        }
        let left = (((self.vec.len() as f64+1.0)/2.0).floor()-1.0) as usize;
        let right = (((self.vec.len() as f64+1.0)/2.0).ceil()-1.0) as usize;
        return ((self.vec[left]+self.vec[right]) as f64)/2.0f64;
    }
}
