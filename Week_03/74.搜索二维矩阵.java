/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][matrix[mid].length - 1] < target) {
                start = mid + 1;
            } else {
                int rowStart = 0;
                int rowEnd = matrix[mid].length - 1;

                while (rowStart <= rowEnd) {
                    int rowMid = (rowStart + rowEnd) / 2;

                    if (matrix[mid][rowMid] == target) return true;
                    if (matrix[mid][rowMid] < target) {
                        rowStart = rowMid + 1;
                    } else {
                        rowEnd = rowMid - 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
// @lc code=end

