impl Solution {
    pub fn min_cost_climbing_stairs(cost: Vec<i32>) -> i32 {
        let mut zero = 0;
        let mut first = 0;
        for c in cost {
            let tmp = first;
            first = c + Ord::min(first, zero);
            zero = tmp;
        }
        return zero.min(first);
    }
}
