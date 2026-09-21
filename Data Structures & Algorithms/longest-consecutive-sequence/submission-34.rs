impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut maxl: i32 = 0;
        let mut uniques: HashSet<i32> = nums.iter().cloned().collect();
        for num in &nums {
            if !uniques.contains(&(num - 1)) {
                let mut len: i32 = 0;
                while uniques.contains(&(num + len)) {
                    len += 1;
                }
                maxl = maxl.max(len);
            }
        }
        return maxl;
    }
}
