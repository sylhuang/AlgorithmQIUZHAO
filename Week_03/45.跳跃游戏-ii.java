import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int count = 0;
        int idx = 0;

        while (idx < nums.length - 1) {
            int tempIdx = 1;

            for (int i = 1; i <= nums[idx]; i++) {
                if (i + idx >= nums.length - 1) return count + 1;

                if (nums[idx + i] + i > nums[idx + tempIdx] + tempIdx) {
                    tempIdx = i;
                }
            }

            idx += tempIdx;
            count++;
        }

        return count;
    }
}
// @lc code=end

