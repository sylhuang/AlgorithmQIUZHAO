/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - nums2.length - 1;
        int j = nums2.length - 1;
        int index = nums1.length - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }

            index--;
        }

        while (j >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }

        return;
    }
}
// @lc code=end

