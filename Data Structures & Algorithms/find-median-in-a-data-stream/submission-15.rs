use std::{cmp::Reverse, collections::BinaryHeap};

pub struct MedianFinder {
    //7, 8, 9
    min: BinaryHeap<Reverse<i32>>,
    //3, 2, 1
    max: BinaryHeap<i32>
}

impl MedianFinder {
    pub fn new() -> Self {
        Self {
            min: BinaryHeap::new(),
            max: BinaryHeap::new()
        }
    }

    pub fn add_num(&mut self, num: i32) {
        if !self.min.is_empty() && num > self.min.peek().unwrap().0 {
            self.min.push(Reverse(num));
        } else {
            self.max.push(num);
        }

        if self.min.len() > self.max.len() + 1 {
            self.max.push(self.min.pop().unwrap().0);
        }

        if self.max.len() > self.min.len() + 1 {
            self.min.push(Reverse(self.max.pop().unwrap()));
        }
    }

    pub fn find_median(&self) -> f64 {
        if self.min.len() > self.max.len() {
            return self.min.peek().unwrap().0 as f64;
        } else if self.max.len() > self.min.len() {
            return *self.max.peek().unwrap() as f64;
        } else {
            return (self.min.peek().unwrap().0 + self.max.peek().unwrap()) as f64 / 2.0
        }
    }
}
