impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let (mut zero, mut first) = (0, 0);
        for num in &nums {
            let tmp = first;
            first = first.max(num + zero);
            zero = tmp;
        }
        return first;
    }
}
