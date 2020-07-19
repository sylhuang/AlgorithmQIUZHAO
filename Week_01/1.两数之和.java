import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];

            if (dict.containsKey(res)) {
                return new int[]{dict.get(res), i};
            }

            dict.put(nums[i], i);
        }

        return new int[]{};
    }
}
// @lc code=end

