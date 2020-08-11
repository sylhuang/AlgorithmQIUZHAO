import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> jumps = new HashMap<>();
        
        for (int i = 0; i < stones.length; i++) {
            jumps.put(stones[i], new HashSet<>());
        }

        jumps.get(0).add(0);
        
        for (int i = 0; i < stones.length; i++) {
            for (int j : jumps.get(stones[i])) {
                for (int step = j - 1; step <= j + 1; step++) {
                    if (step > 0 && jumps.containsKey(stones[i] + step)) {
                        jumps.get(stones[i] + step).add(step);
                    }
                }
            }
        }

        return jumps.get(stones[stones.length - 1]).size() > 0;
    }
}

// @lc code=end

