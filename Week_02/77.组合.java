import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (n == 0 || k == 0) return res;

        List<Integer> comb = new ArrayList<>();

        helper(res, comb, 1, n, k);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> comb, int cur, int n, int k) {
        if (comb.size() == k) {
            res.add(comb);
            return;
        }

        if (k - comb.size() > n - cur + 1) return;

        helper(res, comb, cur + 1, n, k);

        List<Integer> newComb = new ArrayList<>(comb);
        newComb.add(cur);
        helper(res, newComb, cur + 1, n, k);
    }
}
// @lc code=end

