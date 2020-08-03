import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    List<List<Integer>> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if (n == 0) return res;

        List<Integer> solution = new ArrayList<>();

        recurse(solution, n);
        convert(res, n);

        return res;
    }

    private void recurse(List<Integer> solution, int n) {
        if (solution.size() == n) {
            solutions.add(new ArrayList<>(solution));
            
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(solution, i)) {
                solution.add(i);
                recurse(solution, n);
                solution.remove(solution.size() - 1);
            }
        }
    }

    private boolean isValid(List<Integer> solution, int pos) {
        int row = solution.size();

        for (int i = 0; i < row; i++) {
            int prevPos = solution.get(i);

            if (prevPos == pos || prevPos + (row - i) == pos || prevPos - (row - i) == pos) {
                return false;
            }
        }

        return true;
    }

    private void convert(List<List<String>> res, int n) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            str.append('.');
        }

        for (List<Integer> solution : solutions) {
            List<String> sol = new ArrayList<>();

            for (int pos : solution) {
                str.insert(pos, 'Q');
                sol.add(str.toString());
                str.deleteCharAt(pos);
            }

            res.add(sol);
        }
    }
}
// @lc code=end

