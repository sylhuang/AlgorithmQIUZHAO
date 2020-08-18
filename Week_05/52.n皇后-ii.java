/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public int totalNQueens(int n) {
        int cols = 0;
        int left = 0;
        int right = 0;

        return dfs(0, n, cols, left, right, 0);
    }

    private int dfs(int row, int n, int cols, int left, int right, int count) {
        if (row >= n) return count + 1;

        int open = ~(cols | left | right) & ((1 << n) - 1);

        while (open > 0) {
            int pos = open & (-open);
            open = open & (open - 1);
            count = dfs(row + 1, n, cols | pos, (left | pos) << 1, (right | pos) >> 1, count);
        }

        return count;
    }
}
// @lc code=end

