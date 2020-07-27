import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int size = preorder.length;

        if (size == 0) return null;

        for (int i = 0; i < size; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, size - 1, 0, size - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int leftSize = map.get(node.val) - inStart;
        node.left = helper(preorder, inorder, preStart + 1, preStart + leftSize, inStart, inStart + leftSize - 1);
        node.right = helper(preorder, inorder, preStart + leftSize + 1, preEnd, inStart + leftSize + 1, inEnd);

        return node;
    }
}
// @lc code=end

