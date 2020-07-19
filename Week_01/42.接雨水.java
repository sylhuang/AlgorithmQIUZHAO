import java.util.Queue;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int lastPeak = 0;
        int sum = 0;
        int tempSum = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] >= height[lastPeak]) {
                sum += tempSum;
                tempSum = 0;
                lastPeak = i;
            } else {
                tempSum += (height[lastPeak] - height[i]);
            }
        }

        int bound = lastPeak;
        lastPeak = height.length - 1;
        tempSum = 0;

        for (int i = lastPeak; i >= bound; i--) {
            if (height[i] >= height[lastPeak]) {
                sum += tempSum;
                tempSum = 0;
                lastPeak = i;
            } else {
                tempSum += (height[lastPeak] - height[i]);
            }
        }

        return sum;
    }
}
// @lc code=end

