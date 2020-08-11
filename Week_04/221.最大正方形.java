/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] size = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    size[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        size[i][j] = 0;
                    } else {
                        size[i][j] = 1 + Math.min(Math.min(size[i - 1][j], size[i][j - 1]), size[i - 1][j - 1]);
                    }
                }

                max = Math.max(max, size[i][j]);
            }
        }

        return max * max;
    }
}
// @lc code=end

