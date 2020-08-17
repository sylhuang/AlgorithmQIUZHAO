import sun.tools.jar.resources.jar_de;

/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        int[] cir = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            cir[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    int iP = findParent(cir, i);
                    int jP = findParent(cir, j);

                    if (iP != jP) {
                        cir[iP] = jP;
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (i == cir[i]) count++;
        }

        return count;
    }

    private int findParent(int[] cir, int x) {
        int tmp = x;

        while (x != cir[x]) {
            x = cir[x];
        }

        cir[tmp] = x;

        return x;
    }
}
// @lc code=end

