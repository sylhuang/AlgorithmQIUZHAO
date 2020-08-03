/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        int cnt = 0;

        if (grid.length == 0 || grid[0].length == 0) return cnt;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';

        for (int k = 0; k < 4; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }

        
    }
}
// @lc code=end

