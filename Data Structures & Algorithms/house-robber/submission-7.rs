impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let mut zero: i32 = 0;
        let mut first: i32 = 0;
        for num in &nums {
            let tmp: i32 = first;
            first = first.max(num + zero);
            zero = tmp;
        }
        return first;
    }
}
