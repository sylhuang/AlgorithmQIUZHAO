import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;

        if (l == 0) return 0;

        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for (int i = 1; i < l; i++) {
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                // binary search
                int left = 0;
                int right = lis.size() - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (lis.get(mid) == nums[i]) {
                        left = mid;
                        break;
                    } else if (lis.get(mid) < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                lis.set(left, nums[i]);
            }
        }

        return lis.size();
    }
}
// @lc code=end