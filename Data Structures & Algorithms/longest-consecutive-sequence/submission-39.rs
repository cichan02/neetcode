impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut maxl: i32 = 0;
        let uniques: HashSet<i32> = nums.iter().copied().collect();
        for &num in &nums {
            let prev: i32 = num - 1;
            if !uniques.contains(&prev) {
                let mut next: i32 = num;
                while uniques.contains(&next) {
                    next += 1;
                }
                maxl = maxl.max(next - num);
            }
        }
        return maxl;
    }
}
