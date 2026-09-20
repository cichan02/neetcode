use std::cmp;

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let len: usize = nums.len();
        if len == 1 {
            return nums[0];
        }
        cmp::max(Self::robtest(0, len - 1, &nums), Self::robtest(1, len, &nums))
    }

    fn robtest(start: usize, end: usize, nums: &Vec<i32>) -> i32 {
        let mut zero: i32 = 0;
        let mut first: i32 = 0;
        for i in start..end {
            let tmp: i32 = first;
            first = cmp::max(first, zero + nums[i]);
            zero = tmp;
        }
        first
    }
}
