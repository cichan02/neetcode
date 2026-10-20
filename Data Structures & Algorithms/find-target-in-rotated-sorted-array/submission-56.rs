impl Solution {
    pub fn search(nums: Vec<i32>, t: i32) -> i32 {
        let mut l: usize = 0;
        let mut r: usize  = nums.len() - 1;

        while (l <= r) {
            let m = l + (r - l) / 2;
            if nums[m] == t {
                return m as i32;
            }

            if nums[l] <= nums[m] {
                if nums[l] <= t && t < nums[m] {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if nums[m] < t && t <= nums[r] {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        -1
    }
}
