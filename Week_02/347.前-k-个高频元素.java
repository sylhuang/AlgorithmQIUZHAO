import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Node {
    int val;
    int count;

    public Node(int val, int count) {
        this.val = val;
        this.count = count;
    }
}

class nodeComp implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return b.count - a.count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new nodeComp());

        for (int num : map.keySet()) {
            pq.add(new Node(num, map.get(num)));
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().val;
        }

        return res;
    }
}
// @lc code=end

