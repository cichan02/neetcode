use std::cmp;

impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let len: usize = nums.len();

        nums[0]
            .max(Self::robtest(0, len - 1, &nums))
            .max(Self::robtest(1, len, &nums))
    }

    fn robtest(start: usize, end: usize, nums: &Vec<i32>) -> i32 {
        let (mut zero, mut first): (i32, i32) = (0, 0);
        for i in start..end {
            let tmp: i32 = first;
            first = cmp::max(first, zero + nums[i]);
            zero = tmp;
        }
        first
    }
}
