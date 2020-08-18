/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] sqs = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    rows[i][num - '1'] = true;
                    cols[j][num - '1'] = true;
                    sqs[(i / 3) * 3 + j / 3][num - '1'] = true;
                }
            }
        }

        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if (row >= 9) return true;

        for (int j = col; j < 9; j++) {
            if (board[row][j] != '.') continue;

            for (int k = 0; k < 9; k++) {
                if (!rows[row][k] && !cols[j][k] && !sqs[(row / 3) * 3 + j / 3][k]) {
                    rows[row][k] = true;
                    cols[j][k] = true;
                    sqs[(row / 3) * 3 + j / 3][k] = true;
                    board[row][j] = (char)(k + '1');

                    if (dfs(board, row, j)) {
                        return true;
                    } else {
                        rows[row][k] = false;
                        cols[j][k] = false;
                        sqs[(row / 3) * 3 + j / 3][k] = false;
                        board[row][j] = '.';
                    }
                }
            }

            return false;
        }

        return dfs(board, row + 1, 0);
    }
}
// @lc code=end

