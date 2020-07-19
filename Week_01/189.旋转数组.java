/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int nMoved = 0;
        int start = 0;

        while (nMoved < length) {
            int index = start % length;
            int prev = nums[index];

            do {
                int cur = (index + k) % length;
                int temp = nums[cur];
                nums[cur] = prev;
                prev = temp;
                index = cur;
                nMoved++;
            } while (start != index && nMoved < length);

            start++;
        }

        return;
    }
}
// @lc code=end

