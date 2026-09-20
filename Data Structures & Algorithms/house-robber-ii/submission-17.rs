impl Solution {
    pub fn rob(nums: Vec<i32>) -> i32 {
        let len: usize = nums.len();

        nums[0]
            .max(Self::rob_from_to(0, len - 1, &nums))
            .max(Self::rob_from_to(1, len, &nums))
    }

    fn rob_from_to(start: usize, end: usize, nums: &Vec<i32>) -> i32 {
        let (mut zero, mut first): (i32, i32) = (0, 0);
        for i in start..end {
            let tmp: i32 = first;
            first = first.max(zero + nums[i]);
            zero = tmp;
        }
        first
    }
}
