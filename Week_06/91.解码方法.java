/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        int a = 1;
        int b = 1;
        int temp = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }

                temp = a;
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && (s.charAt(i) - '0' <= 6))) {
                temp = a + b;
            } else {
                temp = b;
            }

            a = b;
            b = temp;
        }

        return b;
    }
}
// @lc code=end

