import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        traverse(res, root);

        return res;
    }

    private void traverse(List<Integer> res, TreeNode node) {
        if (node == null) return;

        traverse(res, node.left);
        res.add(node.val);
        traverse(res, node.right);
    }
}
// @lc code=end

