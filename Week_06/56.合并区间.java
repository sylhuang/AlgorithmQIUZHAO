import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int[] interval : intervals) {
            if (ans.size() != 0) {
                int[] lastInv = ans.get(ans.size() - 1);

                if (lastInv[1] >= interval[0]) {
                    lastInv[1] = Math.max(lastInv[1], interval[1]);
                    continue;
                }
            }

            ans.add(interval);
        }

        return ans.toArray(new int[0][]);
    }
}
// @lc code=end

